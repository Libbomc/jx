package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.pojo.Place;

import java.util.Date;
import java.util.List;

/**
 * Created by  on 2018/4/10.
 */
public interface PlaceService {
    /**
     * 极限场地添加
     */
    boolean addPlace(Place place);

    /**
     * 修改
     */
    boolean updatePlace(Place place);

    /**
     * 删除
     */
    boolean deletePlace(Integer placeId);

    List<Place> findByplaceName(String placeName);

    /**
     * 查询所有
     */
    PageInfo<Place> findAll(int pageNum, int pageSize);

    //添加图片路径
    boolean placeUrlimg(String placeUrl, Integer placeId);
}
