package com.onnorokompathshala.videosharingproject.exception;

public class UserNotFoundException extends Exception {
    public  UserNotFoundException(String email){
        super(String.format("User with email %s not found in our system", email));
    }
}
