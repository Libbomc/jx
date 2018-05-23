package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.pojo.Encyclopedia;

import java.util.List;

/**
 * Created by  on 2018/4/10.
 */
public interface EncycloperdiaService {
    /**
     * 极限百科添加
     */
    boolean addEncyclopedia(Encyclopedia encyclopedia);

    /**
     * 修改
     */
    boolean updateEncyclopedia(Encyclopedia encyclopedia);

    /**
     * 删除
     */
    boolean deleteEncyclopedia(Integer encyclopediaId);

    /**
     * 查询单个
     */
    List<Encyclopedia> findEncyclopediaByencyclopediaTitle(String encyclopediaTitle);

    /**
     * 查询所有
     */
    PageInfo<Encyclopedia> findAll(int pageNum, int pageSize);

    //添加图片路径

    boolean encyclopediaUrlimg(String encyclopediaUrl, Integer encyclopediaId);
}
