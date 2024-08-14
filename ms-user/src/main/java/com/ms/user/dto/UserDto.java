package com.ms.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//TODO , Pasar el DTO a Records - Viernes
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String typeDocument;
    private String document;
    private  String name;
}
