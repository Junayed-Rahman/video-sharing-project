package com.onnorokompathshala.videosharingproject.controller;

import com.onnorokompathshala.videosharingproject.entity.VideoEntity;
import com.onnorokompathshala.videosharingproject.exception.UserNotFoundException;
import com.onnorokompathshala.videosharingproject.service.UserService;
import com.onnorokompathshala.videosharingproject.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@AllArgsConstructor
public class VideoController {
    private UserService userService;
    private VideoService videoService;

    @GetMapping("/videos/{id}")
    @ResponseBody
    public String getUploadedVideosByUser(Model model,
                                          @PathVariable("id") long id)
                                          throws UserNotFoundException {
        Collection<VideoEntity> videoEntities = videoService.fetchUploadedVideosByUser(id);
        model.addAttribute("videoList", videoEntities);
        return "c";
    }
}

