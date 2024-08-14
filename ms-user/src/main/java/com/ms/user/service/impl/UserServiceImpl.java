package com.ms.user.service.impl;

import com.ms.user.model.UserEntity;
import com.ms.user.repository.IUserRepository;
import com.ms.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {


    private final IUserRepository iUserRepository;

    @Override
    public ResponseEntity<UserEntity> create(UserEntity userEntity) {
         try{
             var newUser = this.iUserRepository.save(userEntity);

             return ResponseEntity
                     .status(HttpStatus.CREATED)
                     .body(newUser);
         }catch (Exception e){
             return ResponseEntity
                     .badRequest()
                     .build();
         }
    }
}
