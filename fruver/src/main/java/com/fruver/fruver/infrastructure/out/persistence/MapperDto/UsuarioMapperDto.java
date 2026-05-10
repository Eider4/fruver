package com.fruver.fruver.infrastructure.out.persistence.MapperDto;

import com.fruver.fruver.app.dto.UsuarioDTO;
import com.fruver.fruver.app.dto.CrearUsuarioRequestDto;
import com.fruver.fruver.domain.models.Usuario;

import java.util.List;

public class UsuarioMapperDto {

    // 🔄 Domain → DTO (response)
    public static UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;

        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getUid());
        dto.setNombreCompleto(usuario.getNombreCompleto());
        dto.setUsername(usuario.getUsername());
        dto.setRol(usuario.getRol().name()); // 🔥 importante
        dto.setEstado(usuario.getEstadoUsuario().name()); // 🔥 importante
        dto.setPermisoInventario(usuario.getPermisoInventario());
        dto.setCreadoEn(usuario.getCreadoEn());

        return dto;
    }

    // 🔄 DTO → Domain (crear usuario)
    public static Usuario toDomain(CrearUsuarioRequestDto dto) {
        if (dto == null) return null;

        Usuario usuario = new Usuario();
        usuario.setNombreCompleto(dto.getNombreCompleto());
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setPermisoInventario(dto.getPermisoInventario());

        // ⚠️ rol y estado normalmente se asignan en el use case
        return usuario;
    }

    // 🔄 LIST<Domain> → LIST<DTO>
    public static List<UsuarioDTO> toDTOList(List<Usuario> usuarios) {
        if (usuarios == null) return List.of();

        return usuarios.stream()
                .map(UsuarioMapperDto::toDTO)
                .toList();
    }
}