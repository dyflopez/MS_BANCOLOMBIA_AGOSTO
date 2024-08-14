package com.ms.user.service.impl;

import com.ms.user.dto.UserDto;
import com.ms.user.model.UserEntity;
import com.ms.user.repository.IUserRepository;
import com.ms.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {


    private final IUserRepository iUserRepository;

    @Override
    public ResponseEntity<UserEntity> create(UserDto userDto) {
         try{

             UserEntity user = UserEntity
                     .builder()
                     .document(userDto.getDocument())
                     .typeDocument(userDto.getTypeDocument())
                     .name(userDto.getName())
                     .build();
             var newUser = this.iUserRepository.save(user);

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
