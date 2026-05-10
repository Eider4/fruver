package com.fruver.fruver.app.useCase;

import com.fruver.fruver.domain.models.Usuario;
import com.fruver.fruver.domain.ports.in.UsuariosObtenerTodos;
import com.fruver.fruver.domain.ports.out.repository.UsuarioRepositorio;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuariosObtenerTodosImpl implements UsuariosObtenerTodos {
    private final UsuarioRepositorio  usuarioRepositorio;

    public UsuariosObtenerTodosImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepositorio.ObtenerTodos();
    }
}
