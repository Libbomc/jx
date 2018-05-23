package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.pojo.News;

import java.util.List;

/**
 * Created by  on 2018/4/10.
 */
public interface NewsService {
    /**
     * 赛事新闻添加
     */
    boolean addNews(News news);

    /**
     * 修改
     */
    boolean updateNews(News news);

    /**
     * 删除
     */
    boolean deleteNews(Integer newsId);

    List<News> findBynewsTitle(String newsTitle);

    /**
     * 查询所有
     */
    PageInfo<News> findAll(int pageNum, int pageSize);

    //添加图片路径
    boolean newsUrlimg(String newUrl, Integer newsId);
}
