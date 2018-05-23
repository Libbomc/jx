package com.mall.service;

import com.mall.common.ServerResponse;
import com.mall.pojo.Aboutus;

import java.util.List;

/**
 * Created by  on 2018/4/10.
 */
public interface AboutusService {
    /**
     * 关于我们添
     *
     * @return
     */
    boolean addAboutus(Aboutus aboutus);

    /**
     * 关于我们修改
     */
    boolean updateAboutus(Aboutus aboutus);

    /**
     * 删除
     */
    boolean deleteAboutus(Integer aboutusId);

}
