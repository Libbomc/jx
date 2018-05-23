package com.mall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.mall.pojo.Wonmoments;
import com.mall.service.WonmomentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by  on 2018/4/13.
 */
@Controller
@RequestMapping(value = "/jx/Wonmoments/")
@Api(value = "WonmomentsInfo", description = "精彩瞬间信息")
public class WonmomentsController {

    @Autowired
    private WonmomentsService wonmomentsService;

    @RequestMapping(value = "addWonmoments.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "精彩瞬间添加", notes = "精彩瞬间添加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "multipartFile", value = "图片添加,可以进行多个图片上传", dataType = "File", required = true, paramType = "add")
    })
    private boolean addWonmoments(Wonmoments wonmoments, @RequestParam MultipartFile[] multipartFile) throws IllegalStateException, IOException {
        wonmomentsService.addWonmoments(wonmoments);
        List<String> sqlpath = new ArrayList<>();
        String sqlpath1 = null;
        String sqlpath2 = null;
        if (multipartFile != null) {
            //定义存储路径，这个路径可以随意改动，文件夹的名称的命名方式是根据添加数据的ID进行储存
            String path = "E:\\software\\jxx\\src\\main\\webapp\\img\\wonmoments\\" + wonmoments.getWonmomentId() + "\\";
            File file2 = new File(path);
            //判断这个文件夹是否存在，不存在就创建
            if (!file2.exists()) {
                file2.mkdirs();
            }
            System.out.println("12222122211");
            System.out.println(wonmoments.getWonmomentId());
            //判断文件上传是否为空，并且上传的长度
            if (multipartFile != null && multipartFile.length > 0) {
                for (int i = 0; i < multipartFile.length; i++) {
                    //定义将文件以文件数组的方式存放
                    MultipartFile file = multipartFile[i];
                    //得到文件的原始名称
                    String filename = file.getOriginalFilename();
                    //按循环的方式进行将图片命名，但是文件夹的名称的命名方式是根据添加数据的ID进行储存
                    String newFilename = i + filename.substring(filename.lastIndexOf("."));
                    //图片存储在这个ID下的文件夹
                    File file1 = new File(path + "\\" + newFilename);
                    file.transferTo(file1);
                    sqlpath2 = "\\img\\wonmoments\\" + wonmoments.getWonmomentId() + "\\" + newFilename;
                    sqlpath.add(sqlpath2);
                    System.out.println(file);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sqlpath.size(); i++) {
            sb.append(sqlpath);
        }
        sqlpath1 = sqlpath.toString();
        System.out.println(sqlpath.toString());
        System.out.println(sqlpath1);
        wonmomentsService.wonmomentsUrlimg(sqlpath1, wonmoments.getWonmomentId());
        System.out.println("添加成功");
        return true;
    }

    @RequestMapping(value = "updateWonmoments.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "精彩瞬间修改", notes = "精彩瞬间修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "multipartFile", value = "图片修改,直接进行图片选择，按照选择的位置行排然后进行修改", dataType = "File", required = true, paramType = "update")
    })
    private boolean updateWonmoments(Wonmoments wonmoments, @RequestParam MultipartFile[] multipartFile) throws IllegalStateException, IOException {
        wonmomentsService.updateWonmoments(wonmoments);
        List<String> sqlpath = new ArrayList<>();
        String sqlpath1 = null;
        String sqlpath2 = null;
        if (multipartFile != null) {
            //定义存储路径，这个路径可以随意改动，文件夹的名称的命名方式是根据添加数据的ID进行储存
            String path = "E:\\software\\jxx\\src\\main\\webapp\\img\\wonmoments\\" + wonmoments.getWonmomentId() + "\\";
            File file2 = new File(path);
            //判断这个文件夹是否存在，不存在就创建
            if (!file2.exists()) {
                file2.mkdirs();
            }
            System.out.println("12222122211");
            System.out.println(wonmoments.getWonmomentId());
            //判断文件上传是否为空，并且上传的长度
            if (multipartFile != null && multipartFile.length > 0) {
                for (int i = 0; i < multipartFile.length; i++) {
                    //定义将文件以文件数组的方式存放
                    MultipartFile file = multipartFile[i];
                    //得到文件的原始名称
                    String filename = file.getOriginalFilename();
                    //按循环的方式进行将图片命名，但是文件夹的名称的命名方式是根据添加数据的ID进行储存
                    String newFilename = i + filename.substring(filename.lastIndexOf("."));
                    //图片存储在这个ID下的文件夹
                    File file1 = new File(path + "\\" + newFilename);
                    file.transferTo(file1);
                    sqlpath2 = "\\img\\wonmoments\\" + wonmoments.getWonmomentId() + "\\" + newFilename;
                    sqlpath.add(sqlpath2);
                    System.out.println(file);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sqlpath.size(); i++) {
            sb.append(sqlpath);
        }
        sqlpath1 = sqlpath.toString();
        System.out.println(sqlpath.toString());
        System.out.println(sqlpath1);
        wonmomentsService.wonmomentsUrlimg(sqlpath1, wonmoments.getWonmomentId());
        System.out.println("修改成功");
        return true;
    }

    @RequestMapping(value = "deleteWonmoments.do", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "精彩瞬间删除", notes = "精彩瞬间删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "wonmomentId", value = "精彩瞬间id,进行删除会连同该ID下的所有图片进行删除，类型（修改：delete；默认为删除）", required = true, paramType = "delete")
    })
    private boolean deleteWonmoments(Integer wonmomentId) {
        System.out.println(wonmomentId);
        String path = "E:\\software\\jxx\\src\\main\\webapp\\img\\wonmoment\\" + wonmomentId;
        File file = new File(path);
        //file.delete();
        if (!file.isDirectory()) {
            file.delete();
        } else {
            String[] filelist = file.list();
            for (int i = 0; i < filelist.length; i++) {
                File file1 = new File(path + "\\" + filelist[i]);
                //检查外层的文件夹，然后先进行里面的文件删除，再到外层
                if (!file1.isDirectory()) {
                    file1.delete();
                } else if (file1.isDirectory()) {
                    //file1(path+"\\"+filelist[i]);
                }
                file.delete();
            }

        }
        System.out.println("删除成功");
        return wonmomentsService.deleteWonmoments(wonmomentId);
    }
    @RequestMapping(value = "findByplaceName.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "精彩瞬间查询单个", notes = "精彩瞬间查询单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "findBywonmomentTitle", value = "精彩瞬间主题，默认为查看", required = true, paramType = "query")
    })
    private List<Wonmoments> findBywonmomentTitle(String wonmomentsTitle) {
        System.out.println("查询单个");
        return wonmomentsService.findBywonmomentTitle(wonmomentsTitle);
    }

    @RequestMapping(value = "findAllWonmoment.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "精彩瞬间查询所有", notes = "精彩瞬间查询所有")
    private PageInfo<Wonmoments> findAllWonmoment(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                  @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        System.out.println("查询所有");
        return wonmomentsService.findAll(pageNum, pageSize);
    }
}
