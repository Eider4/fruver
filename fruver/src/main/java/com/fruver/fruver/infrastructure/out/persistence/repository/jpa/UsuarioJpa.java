package com.fruver.fruver.infrastructure.out.persistence.repository.jpa;

import com.fruver.fruver.domain.enums.EstadoUsuario;
import com.fruver.fruver.domain.enums.Rol;
import com.fruver.fruver.infrastructure.out.persistence.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioJpa extends JpaRepository<UsuarioEntity, UUID> {

    // 🔍 Buscar por username (login)
    Optional<UsuarioEntity> findByUsername(String username);

    // 🔍 Verificar si existe username
    boolean existsByUsername(String username);

    // 📋 Obtener todos por estado
    List<UsuarioEntity> findByEstado(String estado);

    // 📋 Obtener empleados activos
    List<UsuarioEntity> findByRolAndEstado(Rol rol, EstadoUsuario estado);
}