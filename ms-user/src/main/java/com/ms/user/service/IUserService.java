package com.ms.user.service;

import com.ms.user.model.UserEntity;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    ResponseEntity<UserEntity> create(UserEntity userEntity);
}
