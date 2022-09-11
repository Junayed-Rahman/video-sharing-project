package com.onnorokompathshala.videosharingproject.service;

import com.onnorokompathshala.videosharingproject.dto.UserRegisterDTO;
import com.onnorokompathshala.videosharingproject.entity.UserEntity;
import com.onnorokompathshala.videosharingproject.exception.UserNotFoundException;
import com.onnorokompathshala.videosharingproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserEntity fetchUserById(long id) throws UserNotFoundException {
        System.out.println("Working");
        Optional<UserEntity> user = userRepository.findByUserId(id);
        if (user.isPresent()) {
            System.out.println("user present");
            return user.get();
        } else {
            System.out.println("User not found");
            throw new UserNotFoundException("Email");
        }
    }

    public UserEntity saveUser(UserRegisterDTO userRegisterDTO){
        UserEntity userEntity = modelMapper.map(userRegisterDTO, UserEntity.class);
        UserEntity user = userRepository.save(userEntity);
        return user;
    }
}
