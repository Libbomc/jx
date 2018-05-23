package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.pojo.Culture;

import java.util.List;

/**
 * Created by on 2018/4/10.
 */
public interface CultureService {
    /**
     * 文化板块添加
     */
    boolean addCulture(Culture culture);

    /**
     * 修改
     */
    boolean updateCulture(Culture culture);

    /**
     * 删除
     */
    boolean deleteCulture(Integer cultureId);

    /**
     * 查询单个
     */
    List<Culture> findCultureBycultureName(String cultureName);

    /**
     * 查询所有
     */
    PageInfo<Culture> findAllCulture(int pageNum, int pageSize);

    //添加图片路径

    boolean cultrueUrlimg(String cultrueUrl, Integer cultureId);
}
