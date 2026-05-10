package com.fruver.fruver.app.useCase;

import com.fruver.fruver.domain.enums.EstadoUsuario;
import com.fruver.fruver.domain.enums.Rol;
import com.fruver.fruver.domain.models.Usuario;
import com.fruver.fruver.domain.ports.in.UsuarioCrear;
import com.fruver.fruver.domain.ports.out.repository.UsuarioRepositorio;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public class UsuarioCrearImpl implements UsuarioCrear {

    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioCrearImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public Usuario crear(Usuario user) {

        // 🔴 1. Validar username único
        if (usuarioRepositorio.existePorUsername(user.getUsername())) {
            throw new RuntimeException("El username ya está en uso");
        }

        // 🔴 2. Validar máximo 3 empleados activos
        List<Usuario> empleadosActivos = usuarioRepositorio.obtenerActivosPorRol(Rol.EMPLEADO);

        if (empleadosActivos.size() >= 3) {
            throw new RuntimeException("No se pueden tener más de 3 empleados activos");
        }

        // 🔐 3. Encriptar contraseña (esto idealmente va en un servicio aparte)
        String passwordEncriptado = encriptarPassword(user.getPassword());
        user.setPassword(passwordEncriptado);

        // ⚙️ 4. Asignar valores por defecto
        user.setUid(UUID.randomUUID());
        user.setRol(Rol.EMPLEADO);
        user.setEstadoUsuario(EstadoUsuario.ACTIVO);

        // ⚠️ permisoInventario puede venir null
        if (user.getPermisoInventario() == null) {
            user.setPermisoInventario(false);
        }

        // 💾 5. Guardar
        return usuarioRepositorio.Guardar(user);
    }

    // 🔐 Simulación (debes usar BCrypt en real)
    private String encriptarPassword(String password) {
        return "HASH_" + password;
    }
}