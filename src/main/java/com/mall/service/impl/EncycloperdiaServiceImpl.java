package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.mall.dao.EncyclopediaMapper;
import com.mall.pojo.Encyclopedia;
import com.mall.service.EncycloperdiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by  on 2018/4/10.
 */
@Service("EncycloperdiaService")
public class EncycloperdiaServiceImpl implements EncycloperdiaService {

    @Autowired
    private EncyclopediaMapper encyclopediaMapper;


    @Override
    public boolean addEncyclopedia(Encyclopedia encyclopedia) {
        boolean flag = false;
        try {
            encyclopediaMapper.insert(encyclopedia);
            flag = true;
        } catch (Exception e) {
            System.out.println("添加失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateEncyclopedia(Encyclopedia encyclopedia) {
        boolean flag = false;
        try {
            encyclopediaMapper.updateByPrimaryKeySelective(encyclopedia);
            flag = true;
        } catch (Exception e) {
            System.out.println("修改失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteEncyclopedia(Integer encyclopediaId) {
        boolean flag = false;
        try {
            encyclopediaMapper.deleteByPrimaryKey(encyclopediaId);
            flag = true;
        } catch (Exception e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Encyclopedia> findEncyclopediaByencyclopediaTitle(String encyclopediaTitle) {
        return (List<Encyclopedia>) encyclopediaMapper.selectByPrimaryTitle(encyclopediaTitle);
    }

    @Override
    public PageInfo<Encyclopedia> findAll(int pageNum, int pageSize) {


        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = new ArrayList<Map>();
        List<Encyclopedia> encycloperdiaList = encyclopediaMapper.findAll();

        List<Encyclopedia> list1 = new ArrayList<Encyclopedia>();
        List<Encyclopedia> list2 = new ArrayList<>();
        List<Encyclopedia> list3 = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();

        for (int i = 0; i < encycloperdiaList.size(); i++) {
            if (encycloperdiaList.get(i).getEncyclopediaGenre().equals("滑板")) {
                list1.add(encycloperdiaList.get(i));
            }
            if (encycloperdiaList.get(i).getEncyclopediaGenre().equals("骑行")) {
                list2.add(encycloperdiaList.get(i));
            }
            if (encycloperdiaList.get(i).getEncyclopediaGenre().equals("跑步")) {
                list3.add(encycloperdiaList.get(i));
            }

        }
        map.put("wenzhang", list1);
        map.put("encyclopediaGenre", list1.get(0).getEncyclopediaGenre());
        map1.put("wenzhang", list2);
        map1.put("encyclopediaGenre", list2.get(0).getEncyclopediaGenre());
        map2.put("wenzhang", list3);
        map2.put("encyclopediaGenre", list3.get(0).getEncyclopediaGenre());


        list.add(map);
        list.add(map1);
        list.add(map2);

        PageInfo pageResult = new PageInfo<>(list);

        return pageResult;
    }

    @Override
    public boolean encyclopediaUrlimg(String encyclopediaUrl, Integer encyclopediaId) {
        boolean flag = false;
        encyclopediaMapper.encyclopediaPhoto(encyclopediaUrl, encyclopediaId);
        return flag;

    }
}
