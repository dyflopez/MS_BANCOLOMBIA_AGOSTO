package com.ms.user.controller;

import com.ms.user.controller.docs.UserDoc;
import com.ms.user.dto.UserDto;
import com.ms.user.model.UserEntity;
import com.ms.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/user")
public class UserController implements UserDoc {

    private  final IUserService iUserService;

    @PostMapping
    public ResponseEntity<UserEntity> create(UserDto userDto){
        return  iUserService.create(userDto);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(String id) {
        return iUserService.getById(id);
    }
}
