package com.ms.user.service;

import com.ms.user.dto.UserDto;
import com.ms.user.model.UserEntity;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    ResponseEntity<UserEntity> create(UserDto userDto);

    ResponseEntity<?> getById(String id);
}
