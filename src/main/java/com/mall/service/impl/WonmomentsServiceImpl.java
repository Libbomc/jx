package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.dao.WonmomentsMapper;
import com.mall.pojo.Wonmoments;
import com.mall.service.WonmomentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  on 2018/4/10.
 */
@Service("WonmomentsService")
public class WonmomentsServiceImpl implements WonmomentsService {

    @Autowired
    private WonmomentsMapper wonmomentsMapper;

    @Override
    public boolean addWonmoments(Wonmoments wonmoments) {
        boolean flag = false;
        try {
            wonmomentsMapper.insert(wonmoments);
            flag = true;
        } catch (Exception e) {
            System.out.println("添加失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateWonmoments(Wonmoments wonmoments) {
        boolean flag = false;
        try {
            wonmomentsMapper.updateByPrimaryKeySelective(wonmoments);
            flag = true;
        } catch (Exception e) {
            System.out.println("修改失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteWonmoments(Integer wonmomentId) {
        boolean flag = false;
        try {
            wonmomentsMapper.deleteByPrimaryKey(wonmomentId);
            flag = true;
        } catch (Exception e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Wonmoments> findBywonmomentTitle(String wonmomentTitle) {
        return (List<Wonmoments>) wonmomentsMapper.selectByPrimaryTitle(wonmomentTitle);
    }

    @Override
    public PageInfo<Wonmoments> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Wonmoments> wonmomentsList = wonmomentsMapper.findAll();

        PageInfo<Wonmoments> pageResult = new PageInfo<>(wonmomentsList);
        return pageResult;
    }

    @Override
    public boolean wonmomentsUrlimg(String wonmomentUrl, Integer wonmomentId) {
        boolean flag = false;
        wonmomentsMapper.wonmomentsPhoto(wonmomentUrl, wonmomentId);
        return flag;
    }
}
