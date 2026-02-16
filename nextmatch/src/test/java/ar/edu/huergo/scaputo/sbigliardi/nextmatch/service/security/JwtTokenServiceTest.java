package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.security;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtTokenServiceTest {

    private JwtTokenService jwtTokenService;
    private final String secret = "testSecretKeyForJwtTokenService123456789";
    private final long expirationMillis = 3600000; // 1 hour

    @BeforeEach
    void setUp() {
        jwtTokenService = new JwtTokenService(secret, expirationMillis);
    }

    @Test
    void testGenerarToken_ValidUser_ReturnsToken() {
        // Given
        UserDetails userDetails = mock(UserDetails.class);
        when(userDetails.getUsername()).thenReturn("testuser");
        List<String> roles = List.of("ROLE_USER");

        // When
        String token = jwtTokenService.generarToken(userDetails, roles);

        // Then
        assertNotNull(token);
        assertTrue(token.length() > 0);
    }

    @Test
    void testExtraerUsername_ValidToken_ReturnsUsername() {
        // Given
        UserDetails userDetails = mock(UserDetails.class);
        when(userDetails.getUsername()).thenReturn("testuser");
        List<String> roles = List.of("ROLE_USER");
        String token = jwtTokenService.generarToken(userDetails, roles);

        // When
        String username = jwtTokenService.extraerUsername(token);

        // Then
        assertEquals("testuser", username);
    }

    @Test
    void testEsTokenValido_ValidToken_ReturnsTrue() {
        // Given
        UserDetails userDetails = mock(UserDetails.class);
        when(userDetails.getUsername()).thenReturn("testuser");
        List<String> roles = List.of("ROLE_USER");
        String token = jwtTokenService.generarToken(userDetails, roles);

        // When
        boolean isValid = jwtTokenService.esTokenValido(token, userDetails);

        // Then
        assertTrue(isValid);
    }

    @Test
    void testEsTokenValido_InvalidToken_ReturnsFalse() {
        // Given
        UserDetails userDetails = mock(UserDetails.class);
        when(userDetails.getUsername()).thenReturn("testuser");
        String invalidToken = "invalid.token.here";

        // When
        boolean isValid = jwtTokenService.esTokenValido(invalidToken, userDetails);

        // Then
        assertFalse(isValid);
    }
}
