package com.onnorokompathshala.videosharingproject.repository;

import com.onnorokompathshala.videosharingproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByEmailAndPassword(String email, String password);
}
