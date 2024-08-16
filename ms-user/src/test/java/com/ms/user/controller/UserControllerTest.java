package com.ms.user.controller;

import com.ms.user.dto.UserDto;
import com.ms.user.model.UserEntity;
import com.ms.user.service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserControllerTest {

    @Mock
    private IUserService iUserService;

    @InjectMocks
    private UserController userController;

   /* @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }*/

    @Test
    void create() {

        //Datos de ingres
        UserDto userdto = UserDto
                .builder()
                .document("1030")
                .name("daniel")
                .typeDocument("CC")
                .build();
        // datos a mockear
        UserEntity userEntity = UserEntity
                .builder()
                .document("1030")
                .name("daniel")
                .typeDocument("CC")
                .build();


        // mockear comportamiento

        when(iUserService.create(any())).thenReturn( ResponseEntity.ok(userEntity));

        //Ejecutar

        var respuesta = this.userController.create(userdto);

        //Comprobar JUNIt


        assertNotNull(respuesta);

        //assertEquals(respuesta.getBody().getName(),userdto.getName());
        //assertEquals(respuesta.getBody(),userdto);

        assertEquals(respuesta.getStatusCode(), HttpStatus.OK);

    }

    @Test
    void getUserById() {
    }
}