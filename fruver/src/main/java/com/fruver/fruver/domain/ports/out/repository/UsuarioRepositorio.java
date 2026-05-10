package com.fruver.fruver.domain.ports.out.repository;

import com.fruver.fruver.domain.enums.Rol;
import com.fruver.fruver.domain.models.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UsuarioRepositorio {
    Usuario Guardar (Usuario usuario);
    Optional<Usuario> ObtenerPorUId(UUID uidUsuario);
    List<Usuario> obtenerActivosPorRol(Rol rol);
    Boolean existePorUsername(String username);
    List<Usuario> ObtenerTodos();
}
