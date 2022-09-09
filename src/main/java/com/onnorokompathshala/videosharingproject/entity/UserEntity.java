package com.onnorokompathshala.videosharingproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;
    private String name;
    private String email;
    private String password;
    private String action;
    @ManyToMany
    private List<VideoEntity> likedVideos = new ArrayList<>();
    @ManyToMany
    private List<VideoEntity> dislikedVidoes = new ArrayList<>();
}
