package com.mall.controller.portal;

import com.mall.pojo.Aboutus;
import com.mall.service.AboutusService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by  on 2018/4/11.
 */
@Controller
@RequestMapping(value = "/jx/aboutus/")
@Api(value = "AboutusInfo", description = "关于我们信息")
public class AboutusController {

    @Autowired
    private AboutusService aboutusService;

    @RequestMapping(value = "addAboutus.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "关于我们添加信息", notes = "关于我们添加信息")
    public boolean addAboutus(Aboutus aboutus) {
        System.out.println("添加成功");
        return aboutusService.addAboutus(aboutus);
    }

    @RequestMapping(value = "updateAboutus.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "关于我们修改信息", notes = "关于我们修改信息")
    public boolean updateAboutus(Aboutus aboutus) {
        System.out.println("修改成功");
        return aboutusService.updateAboutus(aboutus);
    }

    @RequestMapping(value = "deleteAboutus.do", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "关于我们删除信息", notes = "关于我们删除信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "AboutusId", value = "id", required = true, paramType = "query")
    })
    public boolean deleteAboutus(Integer aboutusId) {
        System.out.println(aboutusId);
        System.out.println("删除成功");
        return aboutusService.deleteAboutus(aboutusId);
    }
}
