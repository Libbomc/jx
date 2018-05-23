package com.mall.service;

import com.mall.common.ServerResponse;
import com.mall.pojo.Video;

import java.util.List;

/**
 * Created by  on 2018/4/10.
 */
public interface VideoService {
    /**
     * 视频集锦添加
     */
    Video addVideo(Video video);

    /**
     * 修改
     */
    Video updateVideo(Video video);

    /**
     * 删除
     */
    boolean deleteVideo(Integer videoId);

    Video findByvideoTitle(String videoTitle);

    /**
     * 查询所有
     */
    List<Video> findAll();
}
