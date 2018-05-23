package com.mall.controller.backed;

import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.common.config.Const;
import com.mall.pojo.User;
import com.mall.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/manage/user")
public class UserManageController {

    @Autowired
    private UserService userService;


    //管理员登陆
    @RequestMapping(value = "adminlogin.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "管理员登陆", notes = "用户列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", required = true, paramType = "select")
    })
    public ServerResponse<User> adminlogin(String userName, String userPassword, int userAdministrators, HttpSession session) {
        /** String md5password=MD5Util.MD5EncodeUtf8(userPassword);
         System.out.println("开始执行查询admin");
         list= userService.selectByadminName(userName,md5password,userAdministrators);
         if(list!=null) {
         session.setAttribute("username",userName);
         }
         return (List<User>) userService.selectByadminName(userName,md5password,userAdministrators);
         map.put("message","验证码错误");
         Set<String> mapKeySet = map.keySet();
         Set<String> mapValuesSet = new HashSet<String>(map.values());
         List<String> mapValuesList = new ArrayList<String>(map.values());
         list.add((User) mapValuesList);
         System.out.println(list);
         return  list;
         }*/


        ServerResponse<User> response = userService.findUserByuserName(userName, userPassword);
        if (response.isSuccess()) {
            User user = response.getData();
            if (user.getUserRole() == Const.Role.ROLE_ADMIN) {
                session.setAttribute(Const.CURRENT_USER, user);
                return response;
            } else {
                return ServerResponse.createByErrorMessage("不是管理员，无法登陆");
            }
        }
        return response;

    }

    //管理所有的用户
    @RequestMapping(value = "gInformation.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "管理员管理用户", notes = "用户列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "json", required = true, paramType = "select")
    })
    public ServerResponse<PageInfo> gInformation(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                 @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

//       User user= (User) session.getAttribute(Const.CURRENT_USER);
//        if(user==null){
//            return ServerResponse.createByErrorMessage("管理员未登陆");
//        }

        return userService.gInformation(pageNum, pageSize);

    }


}