package com.fruver.fruver.infrastructure.out.persistence.mapper;

import com.fruver.fruver.domain.models.Usuario;
import com.fruver.fruver.infrastructure.out.persistence.entities.UsuarioEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    // 🔄 Entity → Domain
    public static Usuario toDomain(UsuarioEntity entity) {
        if (entity == null) return null;

        Usuario usuario = new Usuario();
        usuario.setUid(entity.getId());
        usuario.setNombreCompleto(entity.getNombreCompleto());
        usuario.setUsername(entity.getUsername());
        usuario.setPassword(entity.getPassword());
        usuario.setRol(entity.getRol());
        usuario.setEstadoUsuario(entity.getEstado());
        usuario.setPermisoInventario(entity.isPermisoInventario());
        usuario.setCreadoEn(entity.getCreadoEn());

        return usuario;
    }

    // 🔄 Domain → Entity
    public static UsuarioEntity toEntity(Usuario domain) {
        if (domain == null) return null;

        UsuarioEntity entity = new UsuarioEntity();
        entity.setNombreCompleto(domain.getNombreCompleto());
        entity.setUsername(domain.getUsername());
        entity.setPassword(domain.getPassword());
        entity.setRol(domain.getRol());
        entity.setEstado(domain.getEstadoUsuario());
        entity.setPermisoInventario(domain.getPermisoInventario());
        entity.setCreadoEn(domain.getCreadoEn());

        return entity;
    }

    // 🔄 LIST<Entity> → LIST<Domain>
    public static List<Usuario> toDomainList(List<UsuarioEntity> entities) {
        if (entities == null) return List.of();

        return entities.stream()
                .map(UsuarioMapper::toDomain)
                .collect(Collectors.toList());
    }

    // 🔄 LIST<Domain> → LIST<Entity>
    public static List<UsuarioEntity> toEntityList(List<Usuario> domains) {
        if (domains == null) return List.of();

        return domains.stream()
                .map(UsuarioMapper::toEntity)
                .collect(Collectors.toList());
    }
}