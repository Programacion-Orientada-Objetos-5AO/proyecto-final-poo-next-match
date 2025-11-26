package ar.edu.huergo.scaputo.sbigliardi.nextmatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.security.RegistrarDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.security.UsuarioDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.security.Usuario;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.mapper.security.UsuarioMapper;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.security.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario-inventario")
public class UsuarioInventarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioMapper usuarioMapper;

    @PostMapping
    public ResponseEntity<UsuarioDTO> registrarCliente(@Valid @RequestBody RegistrarDTO registrarDTO) {
        Usuario usuario = usuarioMapper.toEntity(registrarDTO);
        Usuario nuevoUsuario = usuarioService.registrar(usuario, registrarDTO.password(), registrarDTO.verificacionPassword());
        UsuarioDTO nuevoUsuarioDTO = usuarioMapper.toDTO(nuevoUsuario);
        return ResponseEntity.ok(nuevoUsuarioDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        List<UsuarioDTO> usuarioDTOs = usuarioMapper.toDTOList(usuarios);
        return ResponseEntity.ok(usuarioDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@PathVariable Long id, @Valid @RequestBody RegistrarDTO registrarDTO) {
        Usuario usuario = usuarioMapper.toEntity(registrarDTO);
        Usuario usuarioActualizado = usuarioService.actualizar(id, usuario, registrarDTO.password(), registrarDTO.verificacionPassword());
        UsuarioDTO usuarioDTO = usuarioMapper.toDTO(usuarioActualizado);
        return ResponseEntity.ok(usuarioDTO);
    }

}