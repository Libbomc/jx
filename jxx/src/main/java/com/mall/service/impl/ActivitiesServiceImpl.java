package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.dao.ActivitiesMapper;
import com.mall.pojo.Activities;
import com.mall.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

/**
 * Created by  on 2018/5/8.
 */
@Service("ActivitiesService")
public class ActivitiesServiceImpl implements ActivitiesService {

    @Autowired
    private ActivitiesMapper activitiesMapper;

    @Override
    public boolean addActivities(Activities activities) {
        boolean flag = false;
        try {
            activitiesMapper.insert(activities);
            flag = true;
        } catch (Exception e) {
            System.out.println("添加失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateActivities(Activities activities) {
        boolean flag = false;
        try {
            activitiesMapper.updateByPrimaryKeySelective(activities);
            flag = true;
        } catch (Exception e) {
            System.out.println("修改失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteActivies(Integer activitiesId) {
        boolean flag = false;
        try {
            activitiesMapper.deleteByPrimaryKey(activitiesId);
            flag = true;
        } catch (Exception e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Activities> findActivitiesType(String activitiesType) {
        return activitiesMapper.findActivitiesType(activitiesType);
    }

    @Override
    public PageInfo<List> findAllActivities(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Activities> activitiesList = activitiesMapper.findAllActivities();

        PageInfo result = new PageInfo(activitiesList);
        return result;
    }

    @Override
    public boolean activitiesUrl(String activitiesUrl, Integer activitiesId) {
        boolean flag = false;
        try {
            activitiesMapper.activitiesa(activitiesUrl, activitiesId);
            flag = true;
        } catch (Exception e) {
            System.out.println("图片添加失败");
            e.printStackTrace();
        }

        return flag;
    }
}
