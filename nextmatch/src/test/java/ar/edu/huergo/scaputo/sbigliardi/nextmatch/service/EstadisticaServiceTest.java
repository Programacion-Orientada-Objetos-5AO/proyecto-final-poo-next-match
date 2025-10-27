package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.EstadisticaDTO;

@ExtendWith(MockitoExtension.class)
class EstadisticaServiceTest {

    @InjectMocks
    private EstadisticaService estadisticaService;

    @Test
    void testObtenerEstadisticas_ValidTeamAndLeague_ReturnsDTO() throws Exception {
        // Given
        String nombreEquipo = "Manchester City";
        String nombreLiga = "Premier League";
        int temporada = 2023;

        // When
        EstadisticaDTO result = estadisticaService.obtenerEstadisticas(nombreEquipo, nombreLiga, temporada);

        // Then
        assertNotNull(result);
        assertEquals(nombreEquipo, result.getNombreEquipo());
        assertEquals(nombreLiga, result.getNombreLiga());
        assertEquals(temporada, result.getTemporada());
        assertTrue(result.getPartidosGanados() >= 0);
        assertTrue(result.getPartidosPerdidos() >= 0);
        assertTrue(result.getPartidosEmpatados() >= 0);
        assertTrue(result.getGolesAFavor() >= 0);
        assertTrue(result.getGolesEnContra() >= 0);
    }

    @Test
    void testObtenerEstadisticas_InvalidTeam_ThrowsException() {
        // Given
        String nombreEquipo = "EquipoInexistente";
        String nombreLiga = "Premier League";
        int temporada = 2023;

        // When & Then
        assertThrows(Exception.class, () -> {
            estadisticaService.obtenerEstadisticas(nombreEquipo, nombreLiga, temporada);
        });
    }

    @Test
    void testObtenerEstadisticas_InvalidLeague_ThrowsException() {
        // Given
        String nombreEquipo = "Manchester City";
        String nombreLiga = "LigaInexistente";
        int temporada = 2023;

        // When & Then
        assertThrows(Exception.class, () -> {
            estadisticaService.obtenerEstadisticas(nombreEquipo, nombreLiga, temporada);
        });
    }

    @Test
    void testObtenerEstadisticas_EmptyTeamName_ThrowsException() {
        // Given
        String nombreEquipo = "";
        String nombreLiga = "Premier League";
        int temporada = 2023;

        // When & Then
        assertThrows(Exception.class, () -> {
            estadisticaService.obtenerEstadisticas(nombreEquipo, nombreLiga, temporada);
        });
    }
}
