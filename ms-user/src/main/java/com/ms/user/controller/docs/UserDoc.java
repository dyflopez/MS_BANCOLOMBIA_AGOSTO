package com.ms.user.controller.docs;


import com.ms.user.dto.UserDto;
import com.ms.user.model.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "user controller" , description = "API exposed for CRUD operations on users")
public interface UserDoc {

    @Operation(summary = "create user",description = "this operation is for creating user")
    @ApiResponses(value ={
            @ApiResponse(
                    responseCode = "201",
                    description = "user created",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "internal server error",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "not found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            )
    })
    ResponseEntity<UserEntity> create(@RequestBody UserDto userDto);
}
