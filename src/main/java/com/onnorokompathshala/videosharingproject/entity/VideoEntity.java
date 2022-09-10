package com.onnorokompathshala.videosharingproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "vidoes")
@SecondaryTable(name="user_video_actions")
@Data
@NoArgsConstructor
public class VideoEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "video_id")
    private long id;
    private String description;
    @NotEmpty(message = "URL can not be empty!!")
    @URL(protocol = "https")
    private String url;
    @Column(table = "user_video_actions")
    private long likeCount;
    @Column(table = "user_video_actions")
    private long dislikeCount;
    @Column(table = "user_video_actions")
    private long viewCount;
    @Column(table = "user_video_actions")
    @ManyToOne
    private UserEntity userEntity;
}
