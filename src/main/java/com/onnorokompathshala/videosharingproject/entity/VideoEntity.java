package com.onnorokompathshala.videosharingproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "vidoes")
//@SecondaryTable(name="user_video_actions")
@Data
@NoArgsConstructor
public class VideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "video_id")
    private long videoId;
    @NotEmpty(message = "Video description can not be empty !!")
    private String description;
    @NotEmpty(message = "URL can not be empty!!")
    private String url;
    private long likeCount;
    private long dislikeCount;
    private long viewCount;

    @ManyToOne()
    private UserEntity userEntity;

    @ManyToMany(mappedBy = "likedVideos")
    private Collection<UserEntity> users = new HashSet<>();

    @ManyToMany(mappedBy = "dislikedVideos")
    private Collection<UserEntity> userList = new HashSet<>();
}