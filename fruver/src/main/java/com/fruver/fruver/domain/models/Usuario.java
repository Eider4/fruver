package com.fruver.fruver.domain.models;

import com.fruver.fruver.domain.enums.EstadoUsuario;
import com.fruver.fruver.domain.enums.Rol;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Usuario {
    private UUID uid ;
    private String nombreCompleto;
    private String username;
    private String password;
    private Rol rol ;
    private EstadoUsuario estadoUsuario;
    private Boolean permisoInventario;
    private LocalDateTime creadoEn;

}
