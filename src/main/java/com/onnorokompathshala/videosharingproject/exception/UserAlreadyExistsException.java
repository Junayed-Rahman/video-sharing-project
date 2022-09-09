package com.onnorokompathshala.videosharingproject.exception;

public class UserAlreadyExistsException extends Exception {
    public  UserAlreadyExistsException(String name){
        super(String.format("name %s already registered", name));
    }
}
