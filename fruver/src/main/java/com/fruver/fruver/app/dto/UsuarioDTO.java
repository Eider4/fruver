package com.fruver.fruver.app.dto;

import com.fruver.fruver.domain.enums.EstadoUsuario;
import com.fruver.fruver.domain.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter

public class UsuarioDTO {
    private UUID id;
    private String nombreCompleto;
    private String username;
    private String rol;
    private String estado;
    private Boolean permisoInventario;
    private LocalDateTime creadoEn;
}
