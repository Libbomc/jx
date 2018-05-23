package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.dao.NewsMapper;
import com.mall.pojo.News;
import com.mall.service.NewsService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  on 2018/4/10.
 */
@Service("NewsService")
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public boolean addNews(News news) {
        boolean flag = false;
        try {
            newsMapper.insert(news);
            flag = true;
        } catch (Exception e) {
            System.out.println("添加失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateNews(News news) {
        boolean flag = false;
        try {
            newsMapper.updateByPrimaryKeySelective(news);
            flag = true;
        } catch (Exception e) {
            System.out.println("修改失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteNews(Integer newsId) {
        boolean flag = false;
        try {
            newsMapper.deleteByPrimaryKey(newsId);
            flag = true;
        } catch (Exception e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<News> findBynewsTitle(String newsTitle) {
        return (List<News>) newsMapper.selectByPrimaryTitle(newsTitle);
    }

    @Override
    public PageInfo<News> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<News> newsList = newsMapper.findAll();

        PageInfo<News> pageResult = new PageInfo<>(newsList);

        return pageResult;
    }

    @Override
    public boolean newsUrlimg(String newUrl, Integer newsId) {
        boolean flag = false;
        newsMapper.newsPhoto(newUrl, newsId);
        return flag;
    }
}
