package com.onnorokompathshala.videosharingproject.service;

import com.onnorokompathshala.videosharingproject.dto.UserRegisterDTO;
import com.onnorokompathshala.videosharingproject.entity.UserEntity;
import com.onnorokompathshala.videosharingproject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;

@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;


    public UserEntity saveUser(UserRegisterDTO userRegisterDTO){
        UserEntity userEntity = modelMapper.map(userRegisterDTO, UserEntity.class);
        UserEntity user = userRepository.save(userEntity);
        return user;
    }
}
