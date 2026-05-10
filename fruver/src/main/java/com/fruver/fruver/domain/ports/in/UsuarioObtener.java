package com.fruver.fruver.domain.ports.in;

import com.fruver.fruver.domain.models.Usuario;

import java.util.UUID;

public interface UsuarioObtener {
    Usuario obtener (UUID uidUsuario);
}
