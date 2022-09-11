package com.onnorokompathshala.videosharingproject.repository;

import com.onnorokompathshala.videosharingproject.entity.UserEntity;
import com.onnorokompathshala.videosharingproject.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity,Long> {
    @Query("FROM VideoEntity as v WHERE v.user.userId = :id")
    HashSet<VideoEntity> findUploadedVideosByUserId(@Param("id") long userId);

    @Query("from UserEntity as u WHERE u.likedVideos = :video")
    boolean existingVideoLikedByUser(@Param("video") VideoEntity video);

    Optional<VideoEntity> findByVideoId(long id);
}