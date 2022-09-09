package com.onnorokompathshala.videosharingproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "vidoes")
@Data
@NoArgsConstructor
public class VideoEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "video_id")
    private long id;
    private String url;
    private long viewCount;
}