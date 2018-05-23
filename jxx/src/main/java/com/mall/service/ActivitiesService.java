package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.pojo.Activities;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  on 2018/5/8.
 */

public interface ActivitiesService {

    boolean addActivities(Activities activities);

    boolean updateActivities(Activities activities);

    boolean deleteActivies(Integer activitiesId);

    List<Activities> findActivitiesType(String activitiesType);

    PageInfo<List> findAllActivities(Integer pageNum, Integer pageSize);

    boolean activitiesUrl(String activitiesUrl, Integer activitiesId);
}
