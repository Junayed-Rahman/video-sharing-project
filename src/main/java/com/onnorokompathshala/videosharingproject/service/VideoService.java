package com.onnorokompathshala.videosharingproject.service;

import com.onnorokompathshala.videosharingproject.entity.UserEntity;
import com.onnorokompathshala.videosharingproject.entity.VideoEntity;
import com.onnorokompathshala.videosharingproject.repository.UserRepository;
import com.onnorokompathshala.videosharingproject.repository.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoService {
    private VideoRepository videoRepository;
    private UserRepository userRepository;


    public Collection<VideoEntity> fetchUploadedVideosByUser(long id){
        Collection<VideoEntity> videoList = videoRepository.findUploadedVideosByUserId(id);
        videoList.forEach(videoEntity -> System.out.println(videoEntity));
        return videoList;
    }

    public Collection<VideoEntity> loadAllVideos(){
        Collection<VideoEntity> videoList = videoRepository.findAll();
        return  videoList;
    }

    public boolean videoHasLikeByUser(){
        return true;
    }

}
