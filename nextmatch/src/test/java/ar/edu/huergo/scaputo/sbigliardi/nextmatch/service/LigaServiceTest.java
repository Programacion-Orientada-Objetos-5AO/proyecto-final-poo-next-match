package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LigaServiceTest {

    @InjectMocks
    private LigaService ligaService;

    @Test
    void testObtenerEquiposPorLiga_ValidLeague_ReturnsMap() throws Exception {
        // Given
        String nombreLiga = "Premier League";
        int temporada = 2023;
        String pais = "England";

        // When
        Map<String, Object> result = ligaService.obtenerEquiposPorLiga(nombreLiga, temporada, pais);

        // Then
        assertNotNull(result);
        assertEquals(nombreLiga, result.get("liga"));
        assertEquals(temporada, result.get("temporada"));
        assertEquals(pais, result.get("pais"));
        assertNotNull(result.get("equipos"));
        assertTrue(((java.util.List<?>) result.get("equipos")).size() > 0);
    }

    @Test
    void testObtenerEquiposPorLiga_InvalidLeague_ThrowsException() {
        // Given
        String nombreLiga = "LigaInexistente";
        int temporada = 2023;
        String pais = "England";

        // When & Then
        assertThrows(Exception.class, () -> {
            ligaService.obtenerEquiposPorLiga(nombreLiga, temporada, pais);
        });
    }

    @Test
    void testObtenerEquiposPorLiga_EmptyName_ThrowsException() {
        // Given
        String nombreLiga = "";
        int temporada = 2023;
        String pais = "England";

        // When & Then
        assertThrows(Exception.class, () -> {
            ligaService.obtenerEquiposPorLiga(nombreLiga, temporada, pais);
        });
    }
}
