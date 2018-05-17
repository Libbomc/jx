package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.dao.IntroductionMapper;
import com.mall.pojo.Introduction;
import com.mall.service.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  on 2018/4/10.
 */
@Service("IntroductionService")
public class IntroductionServiceImpl implements IntroductionService {

    @Autowired
    private IntroductionMapper introductionMapper;

    @Override
    public boolean addIntroduction(Introduction introduction) {
        boolean flag = false;
        try {
            introductionMapper.insert(introduction);
            flag = true;
        } catch (Exception e) {
            System.out.println("添加失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateIntroduction(Introduction introduction) {
        boolean flag = false;
        try {
            introductionMapper.updateByPrimaryKeySelective(introduction);
            flag = true;
        } catch (Exception e) {
            System.out.println("修改失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(Integer introductionId) {
        boolean flag = false;
        try {
            introductionMapper.deleteByPrimaryKey(introductionId);
            flag = true;
        } catch (Exception e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Introduction> findByintroductionTitle(String introductionTitle) {
        return (List<Introduction>) introductionMapper.selectByPrimaryTitle(introductionTitle);
    }

    @Override
    public PageInfo<Introduction> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Introduction> introductionList = introductionMapper.findAll();

        PageInfo<Introduction> pageResult = new PageInfo<>(introductionList);
        return pageResult;

    }

    @Override
    public boolean introductionUrlimg(String introductionUrl, Integer introductionId) {
        boolean flag = false;
        introductionMapper.introductionPhoto(introductionUrl, introductionId);
        return flag;
    }
}
