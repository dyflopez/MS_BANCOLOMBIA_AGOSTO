package com.ms.user.service.impl;

import com.ms.user.dto.UserDto;
import com.ms.user.exception.MyHandleException;
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
             var userCurrently = this
                     .iUserRepository
                     .findByDocumentAndTypeDocument(userDto.getDocument(),userDto.getTypeDocument());

             if(userCurrently.isPresent()){// TODO Create consts
                 throw new MyHandleException("El usuario ya existe en la base de datos");
             }

             UserEntity user = UserEntity
                     .builder()
                     .id(UUID.randomUUID().toString())
                     .document(userDto.getDocument())
                     .typeDocument(userDto.getTypeDocument())
                     .name(userDto.getName())
                     .build();
             var newUser = this.iUserRepository.save(user);

             return ResponseEntity
                     .status(HttpStatus.CREATED)
                     .body(newUser);
    }

    @Override
    public ResponseEntity<?> getById(String id) {

        var user = this
                .iUserRepository
                .findById(id)
                .orElseThrow(()-> new MyHandleException("El usuario no existe"));
        return ResponseEntity
                .ok(user);
    }
}
