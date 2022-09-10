package com.onnorokompathshala.videosharingproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "users")
@SecondaryTable(name="user_video_actions")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_id",updatable = false, nullable = false)
    private long userId;
    @NotEmpty(message = "Name can not be empty!!")
    private String name;
    @Email(message = "Mail is not valid !!")
    private String email;
    @NotEmpty
    @Size(min = 4, max = 12, message = "Password must be between 4 characters to 12 characters")
    private String password;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_upload_video",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "video_id"))
    private Collection<VideoEntity> uploadedVideos = new HashSet<>();

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_liked_video",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "video_id"))
    private Collection<VideoEntity> likedVideos = new HashSet<>();

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_disliked_video",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "video_id"))
    private Collection<VideoEntity> dislikedVideos = new HashSet<>();
}
