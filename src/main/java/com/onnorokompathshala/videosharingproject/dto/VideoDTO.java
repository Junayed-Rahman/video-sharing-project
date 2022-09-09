package com.onnorokompathshala.videosharingproject.dto;

import javax.validation.constraints.NotEmpty;

public class VideoDTO {
    @NotEmpty
    private String url;
}
