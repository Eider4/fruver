package com.fruver.fruver.infrastructure.out.persistence.repository.adapters;

import com.fruver.fruver.domain.enums.EstadoUsuario;
import com.fruver.fruver.domain.enums.Rol;
import com.fruver.fruver.domain.models.Usuario;
import com.fruver.fruver.domain.ports.out.repository.UsuarioRepositorio;
import com.fruver.fruver.infrastructure.out.persistence.entities.UsuarioEntity;
import com.fruver.fruver.infrastructure.out.persistence.mapper.UsuarioMapper;
import com.fruver.fruver.infrastructure.out.persistence.repository.jpa.UsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepositorio {

    private final UsuarioJpa usuarioJpa;

    public UsuarioRepositoryAdapter(UsuarioJpa usuarioJpa) {
        this.usuarioJpa = usuarioJpa;
    }

    @Override
    public Usuario Guardar(Usuario usuario) {
        UsuarioEntity entity = UsuarioMapper.toEntity(usuario);
        UsuarioEntity saved = usuarioJpa.save(entity);
        return UsuarioMapper.toDomain(saved);
    }

    @Override
    public Optional<Usuario> ObtenerPorUId(UUID uidUsuario) {
        return usuarioJpa.findById(uidUsuario)
                .map(UsuarioMapper::toDomain);
    }

    @Override
    public List<Usuario> obtenerActivosPorRol(Rol rol) {
        List<UsuarioEntity> entities =
                usuarioJpa.findByRolAndEstado(rol, EstadoUsuario.ACTIVO);

        return UsuarioMapper.toDomainList(entities);
    }

    @Override
    public Boolean existePorUsername(String username) {
        return usuarioJpa.existsByUsername(username);
    }

    @Override
    public List<Usuario> ObtenerTodos() {
        List<UsuarioEntity> entities = usuarioJpa.findAll();
        return UsuarioMapper.toDomainList(entities);
    }
}