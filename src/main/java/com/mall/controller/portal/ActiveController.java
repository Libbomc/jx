package com.mall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.mall.pojo.Active;
import com.mall.service.ActiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by  on 2018/4/11.
 */
@Controller
@RequestMapping(value = "/jx/Active/")
@Api(value = "ActiveInfo", description = "活动回顾表信息")
public class ActiveController {

    @Autowired
    private ActiveService activeService;

    @RequestMapping(value = "addActive.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "活动回顾列表添加", notes = "活动回顾列表添加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "multipartFile", value = "图片添加,可以进行多个图片上传", dataType = "File", required = true, paramType = "add")
    })
    public boolean addActive(Active active, @RequestParam MultipartFile[] multipartFile) throws IllegalStateException, IOException {
/*
        //第一个方法代表单个文件上传
        if (multipartFile != null) {
            String path = "E:\\software\\jxx\\src\\main\\webapp\\img\\active\\";
            String filename = multipartFile.getOriginalFilename();
            //String newfilename= UUID.randomUUID()+filename.substring(filename.lastIndexOf("."));
            String newfilename = active.getActiveId() + filename.substring(filename.lastIndexOf("."));
            File file = new File(path + newfilename);
            multipartFile.transferTo(file);
        }*/
        activeService.addActive(active);
        List<String> sqlpath = new ArrayList<>();
        String sqlpath1 = null;
        String sqlpath2 = null;
        if (multipartFile != null) {
            //定义存储路径，这个路径可以随意改动，文件夹的名称的命名方式是根据添加数据的ID进行储存
            String path = "E://software//jxx//src//main//webapp//img//active//" + active.getActiveId() + "//";
            File file2 = new File(path);
            //判断这个文件夹是否存在，不存在就创建
            if (!file2.exists()) {
                file2.mkdirs();
            }
            System.out.println("12222122211");
            System.out.println(active.getActiveId());
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
                    File file1 = new File(path + "//" + newFilename);
                    file.transferTo(file1);
                    sqlpath2 = "//img//active//" + active.getActiveId() + "//" + newFilename;
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
        activeService.activeUrlimg(sqlpath1, active.getActiveId());
        System.out.println("添加成功");
        return true;
    }

    /*
        @RequestMapping(value="addphoto.do",method = RequestMethod.POST)
        @ResponseBody
        public  String addphoto(MultipartFile multipartFile)throws Exception{
            String path="D:\\img\\";
            String filename=multipartFile.getOriginalFilename();
            String newfilename= UUID.randomUUID()+filename.substring(filename.lastIndexOf("."));
            File file=new File(path+newfilename);
            multipartFile.transferTo(file);
            return "ok";
        }
    */
    @RequestMapping(value = "updateActive.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "活动回顾列表修改", notes = "活动回顾列表修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "multipartFile", value = "图片修改,直接进行图片选择，按照选择的位置行排然后进行修改", dataType = "File", required = true, paramType = "update")
    })
    public boolean updateActive(Active active, @RequestParam MultipartFile[] multipartFile) throws IllegalStateException, IOException {
        activeService.updateActive(active);
        List<String> sqlpath = new ArrayList<>();
        String sqlpath1 = null;
        String sqlpath2 = null;
        if (multipartFile != null) {
            //定义存储路径，这个路径可以随意改动，文件夹的名称的命名方式是根据添加数据的ID进行储存
            String path = "E://software//jxx//src//main//webapp//img//active//" + active.getActiveId() + "//";
            File file2 = new File(path);
            //判断这个文件夹是否存在，不存在就创建
            if (!file2.exists()) {
                file2.mkdirs();
            }
            System.out.println("12222122211");
            System.out.println(active.getActiveId());
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
                    File file1 = new File(path + "//" + newFilename);
                    file.transferTo(file1);
                    sqlpath2 = "//img//active//" + active.getActiveId() + "//" + newFilename;
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
        activeService.activeUrlimg(sqlpath1, active.getActiveId());
        System.out.println("修改成功");
        return true;

    }
    @RequestMapping(value = "deleteActive.do", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "活动回顾列表删除", notes = "活动回顾列表删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activeId", value = "活动回顾id,进行删除会连同该ID下的所有图片进行删除，类型（修改：delete；默认为删除）", required = true, paramType = "delete")
    })
    public boolean deleteActive(Integer activeId) {

      /* if(multipartFile!=null){
          // String path="C:\\Users\\yslaw\\IDEA\\jxx\\src\\main\\webapp\\img\\active\\";
           //String filename=multipartFile.getName();
           //File file=new File(path+filename);
           multipartFile.delete();
       }
*/
        System.out.println(activeId);
        String path = "E://software//jxx//src//main//webapp//img//active//" + activeId;
        File file = new File(path);
        //file.delete();
        if (!file.isDirectory()) {
            file.delete();
        } else {
            String[] filelist = file.list();
            for (int i = 0; i < filelist.length; i++) {
                File file1 = new File(path + "//" + filelist[i]);
                //检查外层的文件夹，然后先进行里面的文件删除，再到外层
                if (!file1.isDirectory()) {
                    file1.delete();
                } else if (file1.isDirectory()) {
                    //file1(path+"\\"+filelist[i]);
                }
                file.delete();
            }
        }
        System.out.println(activeId);
        System.out.println("删除成功");
        return activeService.deleteActive(activeId);
    }

    @RequestMapping(value = "findActiveByactiveName.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "活动回顾查询", notes = "活动回顾查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "活动回顾id，类型（查看：find；默认为查看）", required = true, paramType = "query")
    })
    public List<Active> findActiveByactiveName(String activeName) {
        System.out.println(activeName);
//        String pa=new String((activeName.getBytes("iso-8859-1")),"utf-8");
//        System.out.println(pa);
        System.out.println("查询单个开始");
        return activeService.findActiveByactiveName(activeName);
    }

    @RequestMapping(value = "findAllActive.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "活动回顾查询所有", notes = "活动回顾查询所有")
    public PageInfo<Active> findAllActive(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        System.out.println("查询所有开始");
        return activeService.findAllActive(pageNum, pageSize);
    }
}
