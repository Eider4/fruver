package com.fruver.fruver.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CrearUsuarioRequestDto {
    private String nombreCompleto;
    private String username;
    private String password;
    private Boolean permisoInventario;

}
