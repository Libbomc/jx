package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.pojo.Active;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by on 2018/4/10.
 */
public interface ActiveService {
    /**
     * 活动回顾添加
     *
     * @return
     */
    boolean addActive(Active active);

    /**
     * 活动回顾更新
     */
    boolean updateActive(Active active);

    /**
     * 活动回顾删除
     */
    boolean deleteActive(Integer activeId);

    /**
     * 根据活动名称查单个
     */
    List<Active> findActiveByactiveName(String activeName);

    /**
     * 查询所有
     */
    PageInfo<Active> findAllActive(Integer pageNum, Integer pageSize);

    //添加图片路径
    boolean activeUrlimg(String activeUrl, Integer activeId);
}
