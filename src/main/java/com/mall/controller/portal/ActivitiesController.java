package com.mall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.mall.pojo.Activities;
import com.mall.service.ActivitiesService;
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
 * Created by  on 2018/5/8.
 */
@Controller
@RequestMapping(value = "/jx/Activities/")
public class ActivitiesController {

    @Autowired
    private ActivitiesService activitiesService;

    @RequestMapping(value = "addActivities.do", method = RequestMethod.POST)
    @ResponseBody
    public boolean addActivities(Activities activities, @RequestParam MultipartFile[] multipartFile) throws IOException {
        activitiesService.addActivities(activities);
        List<String> sqlpath = new ArrayList<>();
        String sqlpath1 = null;
        String sqlpath2 = null;
        if (multipartFile != null) {
            //定义存储路径，这个路径可以随意改动，文件夹的名称的命名方式是根据添加数据的ID进行储存
            String path = "E://software//jxx//src//main//webapp//img//activities//" + activities.getActivitiesId() + "//";
            File file2 = new File(path);
            //判断这个文件夹是否存在，不存在就创建
            if (!file2.exists()) {
                file2.mkdirs();
            }
            System.out.println("12222122211");
            System.out.println(activities.getActivitiesId());
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
                    sqlpath2 = "//img//introduction//" + activities.getActivitiesId() + "//" + newFilename;
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
        activitiesService.activitiesUrl(sqlpath1, activities.getActivitiesId());
        System.out.println("添加成功");
        return true;

    }

    @RequestMapping(value = "updateActivities.do", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateActivities(Activities activities) {
        return activitiesService.updateActivities(activities);
    }

    @RequestMapping(value = "deleteActivities.do", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteActivities(Integer activitiesId) {
        return activitiesService.deleteActivies(activitiesId);
    }

    @RequestMapping(value = "findActivitiesType.do", method = RequestMethod.GET)
    @ResponseBody
    public List<Activities> findActivitiesType(String activitiesType) {
        return activitiesService.findActivitiesType(activitiesType);
    }

    @RequestMapping(value = "findAllActivities.do", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Activities> findAllActivities(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                  @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        System.out.print("查询所有");
        return activitiesService.findAllActivities(pageNum, pageSize);
    }
}
