package com.onnorokompathshala.videosharingproject.controller;

import com.onnorokompathshala.videosharingproject.entity.UserEntity;
import com.onnorokompathshala.videosharingproject.entity.VideoEntity;
import com.onnorokompathshala.videosharingproject.exception.UserNotFoundException;
import com.onnorokompathshala.videosharingproject.service.UserService;
import com.onnorokompathshala.videosharingproject.service.VideoService;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.HashSet;

@Controller
@AllArgsConstructor
public class HomeController {
    private UserService userService;
    private VideoService videoService;
    @GetMapping("/")
    @ResponseBody
    public String test() throws UserNotFoundException {

        Collection<VideoEntity> videoEntities = videoService.fetchUploadedVideosByUser(1);
        return "c";
    }
}
