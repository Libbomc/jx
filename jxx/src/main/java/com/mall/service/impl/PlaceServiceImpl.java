package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.dao.PlaceMapper;
import com.mall.pojo.Place;
import com.mall.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by  on 2018/4/10.
 */
@Service("PlaceService")
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceMapper placeMapper;

    @Override
    public boolean addPlace(Place place) {
        boolean flag = false;
        try {
            placeMapper.insert(place);
            flag = true;
        } catch (Exception e) {
            System.out.println("添加失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updatePlace(Place place) {
        boolean flag = false;
        try {
            placeMapper.updateByPrimaryKeySelective(place);
            flag = true;
        } catch (Exception e) {
            System.out.println("修改失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deletePlace(Integer placeId) {
        boolean flag = false;
        try {
            placeMapper.deleteByPrimaryKey(placeId);
            flag = true;
        } catch (Exception e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Place> findByplaceName(String placeName) {
        return (List<Place>) placeMapper.selectByPrimaryName(placeName);
    }

    @Override
    public PageInfo<Place> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Place> placeList = placeMapper.findAll();

        PageInfo<Place> pageResult = new PageInfo<>(placeList);
        return pageResult;
    }

    @Override
    public boolean placeUrlimg(String placeUrl, Integer placeId) {
        boolean flag = false;
        placeMapper.placePhoto(placeUrl, placeId);
        return flag;
    }
}
