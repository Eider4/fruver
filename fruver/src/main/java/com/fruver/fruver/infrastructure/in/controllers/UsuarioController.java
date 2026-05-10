package com.fruver.fruver.infrastructure.in.controllers;

import com.fruver.fruver.app.dto.CrearUsuarioRequestDto;
import com.fruver.fruver.app.dto.UsuarioDTO;
import com.fruver.fruver.app.useCase.UsuarioCrearImpl;
import com.fruver.fruver.app.useCase.UsuarioObtenerImpl;
import com.fruver.fruver.app.useCase.UsuariosObtenerTodosImpl;
import com.fruver.fruver.domain.models.Usuario;
import com.fruver.fruver.domain.ports.in.UsuarioCrear;
import com.fruver.fruver.domain.ports.in.UsuarioObtener;
import com.fruver.fruver.domain.ports.in.UsuariosObtenerTodos;

import com.fruver.fruver.infrastructure.out.persistence.MapperDto.UsuarioMapperDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.PATCH}, allowCredentials = "false")

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioCrearImpl usuarioCrear;
    private final UsuarioObtenerImpl usuarioObtener;
    private final UsuariosObtenerTodosImpl usuariosObtenerTodos;

    public UsuarioController(
            UsuarioCrearImpl usuarioCrear,
            UsuarioObtenerImpl usuarioObtener,
            UsuariosObtenerTodosImpl usuariosObtenerTodos
    ) {
        this.usuarioCrear = usuarioCrear;
        this.usuarioObtener = usuarioObtener;
        this.usuariosObtenerTodos = usuariosObtenerTodos;
    }

    // 🔹 Crear usuario
    @PostMapping
    public ResponseEntity<UsuarioDTO> crear(@RequestBody CrearUsuarioRequestDto dto) {

        Usuario usuario = UsuarioMapperDto.toDomain(dto);

        Usuario creado = usuarioCrear.crear(usuario);

        return ResponseEntity.ok(
                UsuarioMapperDto.toDTO(creado)
        );
    }

    // 🔹 Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtener(@PathVariable UUID id) {

        Usuario usuario = usuarioObtener.obtener(id);

        return ResponseEntity.ok(
                UsuarioMapperDto.toDTO(usuario)
        );
    }

    // 🔹 Listar usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> obtenerTodos() {

        List<Usuario> usuarios = usuariosObtenerTodos.obtenerTodos();

        return ResponseEntity.ok(
                UsuarioMapperDto.toDTOList(usuarios)
        );
    }
}