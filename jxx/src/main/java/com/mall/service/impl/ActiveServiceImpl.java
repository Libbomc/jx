package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.dao.AboutusMapper;
import com.mall.dao.ActiveMapper;
import com.mall.pojo.Active;
import com.mall.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by  on 2018/4/10.
 */
@Service("ActiveService")
public class ActiveServiceImpl implements ActiveService {

    @Autowired
    private ActiveMapper activeMapper;

    @Override
    public boolean addActive(Active active) {
        boolean flag = false;
        try {
          /*  if(ActiveUrl!=null){
                String path="img/active";
                String filename=ActiveUrl.getOriginalFilename();
                String newfilename= UUID.randomUUID()+filename.substring(filename.lastIndexOf("."));
                File file=new File(path+newfilename);
                ActiveUrl.transferTo(file);
            }*/
            activeMapper.insert(active);
            flag = true;
        } catch (Exception e) {
            System.out.println("添加失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateActive(Active active) {
        boolean flag = false;
        try {
            activeMapper.updateByPrimaryKeySelective(active);
            flag = true;
        } catch (Exception e) {
            System.out.println("修改失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteActive(Integer activeId) {
        boolean flag = false;
        try {
            activeMapper.deleteByPrimaryKey(activeId);
            flag = true;
        } catch (Exception e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Active> findActiveByactiveName(String activeName) {
        return (List<Active>) activeMapper.selectByactiveName(activeName);
    }

    @Override
    public PageInfo<Active> findAllActive(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Active> activesList = activeMapper.findAll();

        PageInfo<Active> pageResult = new PageInfo<>(activesList);
        return pageResult;
    }

    @Override
    public boolean activeUrlimg(String activeUrl, Integer activeId) {
        boolean flag = false;
        activeMapper.activea(activeUrl, activeId);
        return false;
    }
}
