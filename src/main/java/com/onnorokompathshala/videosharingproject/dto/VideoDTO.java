package com.onnorokompathshala.videosharingproject.dto;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;

public class VideoDTO {
    @NotEmpty(message = "URL can not be empty !!")
    @URL(protocol = "https")
    private String url;
}
