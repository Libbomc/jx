package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.dao.NoticeMapper;
import com.mall.pojo.Notice;
import com.mall.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  on 2018/4/10.
 */
@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public boolean addNotice(Notice notice) {
        boolean flag = false;
        try {
            noticeMapper.insert(notice);
            flag = true;
        } catch (Exception e) {
            System.out.println("添加失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateNotice(Notice notice) {
        boolean flag = false;
        try {
            noticeMapper.updateByPrimaryKeySelective(notice);
            flag = true;
        } catch (Exception e) {
            System.out.println("修改失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteNotice(Integer noticeId) {
        boolean flag = false;
        try {
            noticeMapper.deleteByPrimaryKey(noticeId);
            flag = true;
        } catch (Exception e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Notice> findBynoticeTitle(String noticeTitle) {
        return (List<Notice>) noticeMapper.selectByPrimaryTitle(noticeTitle);
    }

    @Override
    public PageInfo<Notice> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Notice> noticeList = noticeMapper.findAll();

        PageInfo<Notice> pageResult = new PageInfo<>(noticeList);

        return pageResult;
    }

    @Override
    public boolean noticeUrlimg(String noticeUrl, Integer noticeId) {
        boolean flag = false;
        noticeMapper.noticePhoto(noticeUrl, noticeId);
        return flag;
    }
}
