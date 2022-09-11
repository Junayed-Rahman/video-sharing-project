package com.onnorokompathshala.videosharingproject.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "vidoes")
//@SecondaryTable(name="user_video_actions")
@Getter
@Setter
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
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private UserEntity user;

    @ManyToMany(mappedBy = "likedVideos")
    private Collection<UserEntity> users = new HashSet<>();

    @ManyToMany(mappedBy = "dislikedVideos")
    private Collection<UserEntity> userList = new HashSet<>();

    @Override
    public String toString() {
        return "VideoEntity{" +
                "videoId=" + videoId +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", likeCount=" + likeCount +
                ", dislikeCount=" + dislikeCount +
                ", viewCount=" + viewCount +
                '}';
    }
}