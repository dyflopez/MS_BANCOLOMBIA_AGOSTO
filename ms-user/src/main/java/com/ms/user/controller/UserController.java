package com.ms.user.controller;

import com.ms.user.controller.docs.UserDoc;
import com.ms.user.model.UserEntity;
import com.ms.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/user")
public class UserController implements UserDoc {

    private  final IUserService iUserService;

    @PostMapping
    public ResponseEntity<UserEntity> create(@RequestBody UserEntity userEntity){
        return  iUserService.create(userEntity);
    }
}
