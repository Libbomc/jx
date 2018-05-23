package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.common.ServerResponse;
import com.mall.pojo.Notice;

import java.util.List;

/**
 * Created by  on 2018/4/10.
 */
public interface NoticeService {
    /**
     * 赛事公告添加
     */
    boolean addNotice(Notice notice);

    /**
     * 修改
     */
    boolean updateNotice(Notice notice);

    /**
     * 删除
     */
    boolean deleteNotice(Integer noticeId);

    List<Notice> findBynoticeTitle(String noticeTitle);

    /**
     * 查询所有
     */
    PageInfo<Notice> findAll(int pageNum, int pageSize);

    //添加图片路径
    boolean noticeUrlimg(String noticeUrl, Integer noticeId);
}
