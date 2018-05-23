package com.mall.service.impl;


import com.mall.dao.AboutusMapper;
import com.mall.pojo.Aboutus;
import com.mall.service.AboutusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by  on 2018/4/10.
 */
@Service("AboutusService")
public class AboutusServiceImpl implements AboutusService {

    @Autowired
    private AboutusMapper aboutusMapper;

    @Override
    public boolean addAboutus(Aboutus aboutus) {
        boolean flag = false;
        try {
            aboutusMapper.insert(aboutus);
            flag = true;
        } catch (Exception e) {
            System.out.println("添加失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateAboutus(Aboutus aboutus) {
        boolean flag = false;
        try {
            aboutusMapper.updateByPrimaryKeySelective(aboutus);
            flag = true;
        } catch (Exception e) {
            System.out.println("修改失败");
            e.printStackTrace();
        }
        return flag;
    }


    public boolean deleteAboutus(Integer aboutusId) {
        boolean flag = false;
        //System.out.println(aboutusId);
        try {
            aboutusMapper.deleteByPrimaryKey(aboutusId);
            //System.out.println(aboutusId);
            flag = true;
        } catch (Exception e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }
        return flag;
    }


}
