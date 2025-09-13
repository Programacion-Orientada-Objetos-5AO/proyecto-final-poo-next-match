package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.security;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.security.Rol;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.security.Usuario;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository.security.RolRepository;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository.security.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private RolRepository rolRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    public void testGetAllUsuarios() {
        Usuario usuario1 = new Usuario();
        usuario1.setUsername("user1");
        Usuario usuario2 = new Usuario();
        usuario2.setUsername("user2");

        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario1, usuario2));

        List<Usuario> result = usuarioService.getAllUsuarios();

        assertEquals(2, result.size());
        assertEquals("user1", result.get(0).getUsername());
    }

    @Test
    public void testRegistrar() {
        Usuario usuario = new Usuario();
        usuario.setUsername("user@example.com");
        String password = "Password123!";
        String verificacionPassword = "Password123!";
        Rol rol = new Rol();
        rol.setNombre("CLIENTE");

        when(passwordEncoder.encode(password)).thenReturn("encodedPassword");
        when(rolRepository.findByNombre("CLIENTE")).thenReturn(Optional.of(rol));
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario result = usuarioService.registrar(usuario, password, verificacionPassword);

        assertEquals("user@example.com", result.getUsername());
        verify(passwordEncoder).encode(password);
        verify(rolRepository).findByNombre("CLIENTE");
        verify(usuarioRepository).save(usuario);
    }

    @Test
    public void testRegistrarPasswordMismatch() {
        Usuario usuario = new Usuario();
        String password = "Password123!";
        String verificacionPassword = "DifferentPassword123!";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.registrar(usuario, password, verificacionPassword);
        });

        assertEquals("Las contraseñas no coinciden", exception.getMessage());
    }

    @Test
    public void testRegistrarUsernameExists() {
        Usuario usuario = new Usuario();
        usuario.setUsername("user@example.com");
        String password = "Password123!";
        String verificacionPassword = "Password123!";

        when(usuarioRepository.existsByUsername("user@example.com")).thenReturn(true);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.registrar(usuario, password, verificacionPassword);
        });

        assertEquals("El nombre de usuario ya está en uso", exception.getMessage());
    }

    @Test
    public void testRegistrarRolNotFound() {
        Usuario usuario = new Usuario();
        usuario.setUsername("user@example.com");
        String password = "Password123!";
        String verificacionPassword = "Password123!";

        when(passwordEncoder.encode(password)).thenReturn("encodedPassword");
        when(rolRepository.findByNombre("CLIENTE")).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.registrar(usuario, password, verificacionPassword);
        });

        assertEquals("Rol 'CLIENTE' no encontrado", exception.getMessage());
    }
}
