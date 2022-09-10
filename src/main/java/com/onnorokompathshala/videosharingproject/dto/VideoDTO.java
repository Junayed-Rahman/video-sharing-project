package com.onnorokompathshala.videosharingproject.dto;

import javax.validation.constraints.NotEmpty;

public class VideoDTO {
    @NotEmpty(message = "URL can not be empty !!")
    private String url;
}
