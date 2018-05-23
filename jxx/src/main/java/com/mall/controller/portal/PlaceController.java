package com.mall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.mall.pojo.Place;
import com.mall.service.PlaceService;
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
@RequestMapping(value = "/jx/Place/")
@Api(value = "PlaceInfo", description = "极限场地信息")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "addPlace.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "极限场地添加", notes = "极限场地添加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "multipartFile", value = "图片添加,可以进行多个图片上传", dataType = "File", required = true, paramType = "add")
    })
    private boolean addPlace(Place place, @RequestParam MultipartFile[] multipartFile) throws IllegalStateException, IOException {
        placeService.addPlace(place);
        List<String> sqlpath = new ArrayList<>();
        String sqlpath1 = null;
        String sqlpath2 = null;
        if (multipartFile != null) {
            //定义存储路径，这个路径可以随意改动，文件夹的名称的命名方式是根据添加数据的ID进行储存
            String path = "E:\\software\\jxx\\src\\main\\webapp\\img\\place\\" + place.getPlaceId() + "\\";
            File file2 = new File(path);
            //判断这个文件夹是否存在，不存在就创建
            if (!file2.exists()) {
                file2.mkdirs();
            }
            System.out.println("12222122211");
            System.out.println(place.getPlaceId());
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
                    sqlpath2 = "\\img\\place\\" + place.getPlaceId() + "\\" + newFilename;
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
        placeService.placeUrlimg(sqlpath1, place.getPlaceId());
        System.out.println("添加成功");
        return true;
    }

    @RequestMapping(value = "updatePlace.do", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "极限场地修改", notes = "极限场地修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "multipartFile", value = "图片修改,直接进行图片选择，按照选择的位置行排然后进行修改", dataType = "File", required = true, paramType = "update")
    })
    private boolean updatePlace(Place place, @RequestParam MultipartFile[] multipartFile) throws IllegalStateException, IOException {
        placeService.updatePlace(place);
        List<String> sqlpath = new ArrayList<>();
        String sqlpath1 = null;
        String sqlpath2 = null;
        if (multipartFile != null) {
            //定义存储路径，这个路径可以随意改动，文件夹的名称的命名方式是根据添加数据的ID进行储存
            String path = "E:\\software\\jxx\\src\\main\\webapp\\img\\place\\" + place.getPlaceId() + "\\";
            File file2 = new File(path);
            //判断这个文件夹是否存在，不存在就创建
            if (!file2.exists()) {
                file2.mkdirs();
            }
            System.out.println("12222122211");
            System.out.println(place.getPlaceId());
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
                    sqlpath2 = "\\img\\place\\" + place.getPlaceId() + "\\" + newFilename;
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
        placeService.placeUrlimg(sqlpath1, place.getPlaceId());
        System.out.println("修改成功");
        return true;
    }

    @RequestMapping(value = "deletePlace.do", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "极限场地删除", notes = "极限场地删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "placeId", value = "极限场地id,进行删除会连同该ID下的所有图片进行删除，类型（修改：delete；默认为删除）", required = true, paramType = "delete")
    })
    private boolean deletePlace(Integer placeId) {
        String path = "E:\\software\\jxx\\src\\main\\webapp\\img\\place\\" + placeId;
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
        return placeService.deletePlace(placeId);
    }

    @RequestMapping(value = "findByplaceName.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "极限场地查询单个", notes = "极限场地查询单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "findByplaceName", value = "极限场地名称，默认为查看", required = true, paramType = "query")
    })
    private List<Place> findByplaceName(String placeName) {
        System.out.println("查询单个");
        return placeService.findByplaceName(placeName);
    }

    @RequestMapping(value = "findAllPlace.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "极限场地查询所有", notes = "极限场地查询所有")
    private PageInfo<Place> findAllPlace(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        System.out.println("查询所有");
        return placeService.findAll(pageNum, pageSize);
    }
}
