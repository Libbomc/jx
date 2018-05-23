package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.pojo.Wonmoments;

import java.util.List;

/**
 * Created by  on 2018/4/10.
 */
public interface WonmomentsService {
    /**
     * 精彩瞬间添加
     */
    boolean addWonmoments(Wonmoments wonmoments);

    /**
     * 修改
     */
    boolean updateWonmoments(Wonmoments wonmoments);

    /**
     * 删除
     */
    boolean deleteWonmoments(Integer wonmomentId);

    List<Wonmoments> findBywonmomentTitle(String wonmomentTitle);

    /**
     * 查询所有
     */
    PageInfo<Wonmoments> findAll(int pageNum, int pageSize);

    //添加图片路径
    boolean wonmomentsUrlimg(String wonmomentUrl, Integer wonmomentId);
}
