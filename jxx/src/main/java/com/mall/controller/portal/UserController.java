package com.mall.controller.portal;


import com.mall.common.ServerResponse;
import com.mall.common.config.Const;
import com.mall.pojo.User;
import com.mall.service.UserService;

import com.mall.util.MD5Util;
import com.mall.util.SMSUtil;
import com.mall.util.VerificationCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

import static com.mall.common.config.Const.CURRENT_USER;

@Controller
@RequestMapping("/jx/User")
@Api(value = "UserInfo", description = "用户信息")
public class UserController {
    @Autowired
    private UserService userService;
    String a;

    //注册用户
    @RequestMapping(value = "addUser.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "注册用户", notes = "用户列表添加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", required = true, paramType = "add")
    })
    public ServerResponse<User> addUser(User user, String buffer) {
        if (buffer.equals(a)) {
            return userService.addUser(user);
        } else {
            return ServerResponse.createByErrorMessage("验证码错误");
        }
    }

    //验证码
    @RequestMapping(value = "vcode.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<User> vcode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerificationCodeUtil.outputCaptcha(request, response);
        a = VerificationCodeUtil.a;
        return ServerResponse.createBySuccessMessage("验证码已生成");
    }


    //用户登陆
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "用户登陆", notes = "用户列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", required = true, paramType = "select")
    })
    public ServerResponse<User> login(String userName, String userPassword, String buffer, HttpSession session) {
        ServerResponse<User> response = userService.findUserByuserName(userName, userPassword);
        //验证码
        if (buffer.equals(a)) {
            System.out.println("开始执行user登陆");
            if (response.isSuccess()) {
                session.setAttribute(CURRENT_USER, response.getData());
            }
            return response;
        } else {
            System.out.println("验证码不正确");
            return ServerResponse.createByErrorMessage("验证码错误");
        }
    }

    //用户退出当前登陆
    @RequestMapping(value = "logout.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    //用户更改密码之前向手机发送验证码
    @RequestMapping(value = "SMSphone.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "发送验证码", notes = "用户验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", required = true, paramType = "update")
    })
    public ServerResponse<User> SMSphone(String userPhone) throws Exception {
        ServerResponse<String> result = userService.checkuserPhone(userPhone);
        if (result.isSuccess()) {
            String code = SMSUtil.getsms(userPhone);
            if (code.equals("OK")) {
                return ServerResponse.createBySuccessMessage("短信已发送");
            }
            return ServerResponse.createByErrorMessage("短信发送不成功");
        }
        return ServerResponse.createByErrorMessage("手机号不存在");
    }

    //用户更改密码
    @RequestMapping(value = "updatePW.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新用户信息", notes = "用户列表更改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", required = true, paramType = "update")
    })
    public ServerResponse<String> updatePW(String userName, String userPassword,int phone) {
        int phoneVE=SMSUtil.getCode();
        if(phone==phoneVE) {
            String a = MD5Util.MD5EncodeUtf8(userPassword);
            ServerResponse<String> result = userService.update(userName, a);
            if (result.isSuccess()) {
                return ServerResponse.createBySuccessMessage("密码更改成功,请重新登陆");
            }

            return ServerResponse.createByErrorMessage("密码更改不成功");
            //return userService.update(userName);
        }
        return ServerResponse.createByErrorMessage("验证错误");
    }


    @RequestMapping(value = "updateIF.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新用户信息", notes = "用户列表更改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", required = true, paramType = "update")
    })
    //用户更改账号信息
    public ServerResponse<User> updateIF(User user) {
        ServerResponse<User> u = userService.updateInformation(user);
        if (u.isSuccess()) {
            return ServerResponse.createBySuccessMessage("更改成功");
        }
        return ServerResponse.createBySuccessMessage("更改不成功");
    }


/**
 //shiro
 @RequestMapping(value = "/dologin.do",method = RequestMethod.POST)
 @ResponseBody public String login1(@RequestParam("userName")String userName,@RequestParam("userPassword")String userPassword){
 String str=null;
 org.apache.shiro.subject.Subject subject=SecurityUtils.getSubject();
 UsernamePasswordToken token=new UsernamePasswordToken(userName,userPassword);
 try {
 subject.login(token);

 onlineSessionManager.addOnlineSession(subject.getSession().getId());
 User user=userService.getByUserName(token.getUsername());

 subject.getSession().setAttribute("userLogin", user);
 Map<String ,Object> map=new HashMap<String,Object>();
 map.put("erroe",0);
 map.put("msg","登陆成功");
 map.put("token",subject.getSession().getId());
 }catch (IncorrectCredentialsException e){
 Map<String ,Object> map=new HashMap<String,Object>();
 map.put("用户名或密码错误", 405);
 str=map.toString();
 }
 return str;
 }

 */

}
