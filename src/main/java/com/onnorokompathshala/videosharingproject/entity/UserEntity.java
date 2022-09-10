package com.onnorokompathshala.videosharingproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@SecondaryTable(name="user_video_actions")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_id",updatable = false, nullable = false)
    private long id;
    @NotEmpty(message = "Name can not be empty!!")
    private String name;
    @Email(message = "Mail is not valid !!")
    private String email;
    @NotEmpty
    @Size(min = 4, max = 12, message = "Password must be between 4 characters to 12 characters")
    private String password;
    @Column(table = "user_video_actions")
    private String action;
    @Column(table = "user_video_actions")
    @ManyToMany
    private List<VideoEntity> likedVideos = new ArrayList<>();
    @Column(table = "user_video_actions")
    @ManyToMany
    private List<VideoEntity> dislikedVidoes = new ArrayList<>();
}
