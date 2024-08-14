package com.ms.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @NotEmpty
    @Size(min = 2,max = 10)
    @Pattern(regexp = "^(?:CC|CE)$" , message = "el dato debe ser CC o CE")
    private String typeDocument;

    @NotBlank
    @NotEmpty
    @Size(min = 6,max = 10 ,message = "el rango no es valido")
    @Pattern(regexp = "^[0-9]*$" , message = "Solo se permite numeros")
    private String document;

    @NotBlank
    @NotEmpty
    @Size(min = 3,max = 8)
    private  String name;
}
