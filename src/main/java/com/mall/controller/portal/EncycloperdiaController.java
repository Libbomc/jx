package com.mall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Utf8;
import com.mall.pojo.Encyclopedia;
import com.mall.service.EncycloperdiaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by  on 2018/4/11.
 */
@Controller
@RequestMapping("/jx/Encycloperdia/")
@Api(value = "EncycloperdiaInfo", description = "极限百科表信息")
public class EncycloperdiaController {

    @Autowired
    private EncycloperdiaService encycloperdiaService;

    @RequestMapping(value = "addEncycloperdia.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "极限百科添加", notes = "极限百科添加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "multipartFile", value = "图片添加,可以进行多个图片上传", dataType = "File", required = true, paramType = "add")
    })
    private boolean addEncycloperdia(Encyclopedia encyclopedia, @RequestParam MultipartFile[] multipartFile) throws IllegalStateException, IOException {
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
        encycloperdiaService.addEncyclopedia(encyclopedia);
        List<String> sqlpath = new ArrayList<>();
        String sqlpath1 = null;
        String sqlpath2 = null;
        if (multipartFile != null) {
            //定义存储路径，这个路径可以随意改动，文件夹的名称的命名方式是根据添加数据的ID进行储存
            String path = "E://software//jxx//src//main//webapp//img//encyclopedia//" + encyclopedia.getEncyclopediaId() + "//";
            File file2 = new File(path);
            //判断这个文件夹是否存在，不存在就创建
            if (!file2.exists()) {
                file2.mkdirs();
            }
            System.out.println("12222122211");
            System.out.println(encyclopedia.getEncyclopediaId());
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
                    sqlpath2 = "//img//encyclopedia//" + encyclopedia.getEncyclopediaId() + "//" + newFilename;
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
        encycloperdiaService.encyclopediaUrlimg(sqlpath1, encyclopedia.getEncyclopediaId());
        System.out.println("添加成功");
        return true;
    }

    @RequestMapping(value = "updateEncycloperdia.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "极限百科修改", notes = "极限百科修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "multipartFile", value = "图片更新,可以进行多个图片上传", dataType = "File", required = true, paramType = "update")
    })
    private boolean updateEncycloperdia(Encyclopedia encyclopedia, @RequestParam MultipartFile[] multipartFile) throws IllegalStateException, IOException {
        encycloperdiaService.updateEncyclopedia(encyclopedia);
        List<String> sqlpath = new ArrayList<>();
        String sqlpath1 = null;
        String sqlpath2 = null;
        if (multipartFile != null) {
            //定义存储路径，这个路径可以随意改动，文件夹的名称的命名方式是根据添加数据的ID进行储存
            String path = "E://software//jxx//src//main//webapp//img//encyclopedia//" + encyclopedia.getEncyclopediaId() + "//";
            File file2 = new File(path);
            //判断这个文件夹是否存在，不存在就创建
            if (!file2.exists()) {
                file2.mkdirs();
            }
            System.out.println("12222122211");
            System.out.println(encyclopedia.getEncyclopediaId());
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
                    sqlpath2 = "//img//encyclopedia//" + encyclopedia.getEncyclopediaId() + "//" + newFilename;
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
        encycloperdiaService.encyclopediaUrlimg(sqlpath1, encyclopedia.getEncyclopediaId());
        System.out.println("修改成功");
        return true;
    }

    @RequestMapping(value = "deleteEncycloperdia.do", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "极限百科删除", notes = "极限百科删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "encyclopediaId", value = "极限百科id,进行删除会连同该ID下的所有图片进行删除，类型（修改：delete；默认为删除）", required = true, paramType = "delete")
    })
    private boolean deleteEncycloperdia(Integer encyclopediaId) {
        System.out.println();
        String path = "E://software//jxx//src//main//webapp//img//encyclopedia//" + encyclopediaId;
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
        System.out.println("删除成功");
        return encycloperdiaService.deleteEncyclopedia(encyclopediaId);
    }

    @RequestMapping(value = "findEncyclopediaByencyclopediaTitle.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "极限百科查询单个", notes = "极限百科查询单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "encyclopediaName", value = "极限百科名称，默认为查看", required = true, paramType = "query")
    })
    private List<Encyclopedia> findEncyclopediaByencyclopedia(String encyclopediaTitle, HttpServletRequest request) {
        System.out.println(encyclopediaTitle);
        System.out.println("查询单个");
        return encycloperdiaService.findEncyclopediaByencyclopediaTitle(encyclopediaTitle);
    }

    @RequestMapping(value = "findAllEncyclopedia.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "文化板块查询所有", notes = "文化板块查询所有")
    private PageInfo<Encyclopedia> findAllEncyclopedia(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                       @RequestParam(value = "pageSize", defaultValue = "1000") int pageSize) {
        System.out.println("查询所有");
        return encycloperdiaService.findAll(pageNum, pageSize);
    }

}
