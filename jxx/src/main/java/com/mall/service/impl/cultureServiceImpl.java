package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.dao.CultureMapper;
import com.mall.pojo.Culture;
import com.mall.service.CultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  on 2018/4/10.
 */
@Service("CultureService")
public class cultureServiceImpl implements CultureService {

    @Autowired
    private CultureMapper cultureMapper;

    @Override
    public boolean addCulture(Culture culture) {
        boolean flag = false;
        try {
            cultureMapper.insert(culture);
            flag = true;
        } catch (Exception e) {
            System.out.println("添加失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateCulture(Culture culture) {
        boolean flag = false;
        try {
            cultureMapper.updateByPrimaryKeySelective(culture);
            flag = true;
        } catch (Exception e) {
            System.out.println("修改失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteCulture(Integer cultureId) {
        boolean flag = false;
        try {
            cultureMapper.deleteByPrimaryKey(cultureId);
            flag = true;
        } catch (Exception e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Culture> findCultureBycultureName(String cultureName) {
        return (List<Culture>) cultureMapper.selectByPrimaryName(cultureName);
    }

    @Override
    public PageInfo<Culture> findAllCulture(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Culture> cultureList = cultureMapper.findAll();

        PageInfo<Culture> pageResult = new PageInfo<>(cultureList);

        return pageResult;
    }

    @Override
    public boolean cultrueUrlimg(String cultrueUrl, Integer cultureId) {
        boolean flag = false;
        cultureMapper.cultruePhoto(cultrueUrl, cultureId);
        return flag;
    }
}
