package ar.edu.huergo.scaputo.sbigliardi.nextmatch.controller.security;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.security.RegistrarDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.security.UsuarioDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.security.Usuario;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.mapper.security.UsuarioMapper;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.security.UsuarioService;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @MockBean
    private UsuarioMapper usuarioMapper;

    @Test
    public void testRegistrarCliente() throws Exception {
        String registrarJson = "{\"username\":\"user\",\"email\":\"user@example.com\",\"password\":\"pass\",\"verificacionPassword\":\"pass\"}";
        Usuario usuario = new Usuario();
        usuario.setUsername("user");
        UsuarioDTO usuarioDTO = new UsuarioDTO("user", Arrays.asList("CLIENTE"));

        when(usuarioMapper.toEntity(any(RegistrarDTO.class))).thenReturn(usuario);
        when(usuarioService.registrar(any(Usuario.class), eq("pass"), eq("pass"))).thenReturn(usuario);
        when(usuarioMapper.toDTO(any(Usuario.class))).thenReturn(usuarioDTO);

        mockMvc.perform(post("/equipo/usuarios/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(registrarJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("user"))
                .andExpect(jsonPath("$.roles[0]").value("CLIENTE"));
    }

    @Test
    public void testGetAllUsuarios() throws Exception {
        Usuario usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setUsername("user1");
        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setUsername("user2");
        UsuarioDTO dto1 = new UsuarioDTO("user1", Arrays.asList("CLIENTE"));
        UsuarioDTO dto2 = new UsuarioDTO("user2", Arrays.asList("CLIENTE"));

        when(usuarioService.getAllUsuarios()).thenReturn(Arrays.asList(usuario1, usuario2));
        when(usuarioMapper.toDTOList(anyList())).thenReturn(Arrays.asList(dto1, dto2));

        mockMvc.perform(get("/equipo/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username").value("user1"))
                .andExpect(jsonPath("$[1].username").value("user2"));
    }
}
