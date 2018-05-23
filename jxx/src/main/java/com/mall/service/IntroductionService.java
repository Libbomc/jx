package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.pojo.Introduction;

import java.util.List;

/**
 * Created by  on 2018/4/10.
 */
public interface IntroductionService {

    /**
     * 运动介绍添加
     */
    boolean addIntroduction(Introduction introduction);

    /**
     * 修改
     */
    boolean updateIntroduction(Introduction introduction);

    /**
     * 删除
     */
    boolean delete(Integer introductionId);

    /**
     * 单个
     */
    List<Introduction> findByintroductionTitle(String introductionTitle);

    /**
     * 查询所有
     */
    PageInfo<Introduction> findAll(int pageNum, int pageSize);

    //添加图片路径
    boolean introductionUrlimg(String introductionUrl, Integer introductionId);
}
