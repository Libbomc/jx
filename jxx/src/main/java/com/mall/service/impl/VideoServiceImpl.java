package com.mall.service.impl;

import com.mall.common.ServerResponse;
import com.mall.pojo.Video;
import com.mall.service.VideoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  on 2018/4/10.
 */
@Service("VideoService")
public class VideoServiceImpl implements VideoService {

    @Override
    public Video addVideo(Video video) {
        return null;
    }

    @Override
    public Video updateVideo(Video video) {
        return null;
    }

    @Override
    public boolean deleteVideo(Integer videoId) {
        return false;
    }

    @Override
    public Video findByvideoTitle(String videoTitle) {
        return null;
    }

    @Override
    public List<Video> findAll() {
        return null;
    }
}
