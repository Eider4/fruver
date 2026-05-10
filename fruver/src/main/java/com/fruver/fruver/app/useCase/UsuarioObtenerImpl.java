package com.fruver.fruver.app.useCase;

import com.fruver.fruver.domain.models.Usuario;
import com.fruver.fruver.domain.ports.in.UsuarioObtener;
import com.fruver.fruver.domain.ports.out.repository.UsuarioRepositorio;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UsuarioObtenerImpl implements UsuarioObtener {
    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioObtenerImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public Usuario obtener(UUID uidUsuario) {
        if (uidUsuario == null){
            throw new RuntimeException("El id es necesario");
        }
        return usuarioRepositorio.ObtenerPorUId(uidUsuario)
                .orElseThrow(() -> new RuntimeException("El usuario no existe"));
    }
}
