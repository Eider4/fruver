package com.fruver.fruver.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ListarUsuarios {
    private List<UsuarioDTO> empleados;  
}
