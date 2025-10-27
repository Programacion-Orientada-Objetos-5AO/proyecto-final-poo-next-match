package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HistorialServiceTest {

    @InjectMocks
    private HistorialService historialService;

    @Test
    void testObtenerHistorialEntreEquipos_ValidTeams_ReturnsMap() throws Exception {
        // Given
        String equipo1 = "Boca Juniors";
        String equipo2 = "River Plate";

        // When
        Map<String, Object> result = historialService.obtenerHistorialEntreEquipos(equipo1, equipo2);

        // Then
        assertNotNull(result);
        assertEquals(equipo1, result.get("equipo1"));
        assertEquals(equipo2, result.get("equipo2"));
        assertNotNull(result.get("ganados1"));
        assertNotNull(result.get("empatados"));
        assertNotNull(result.get("ganados2"));
    }

    @Test
    void testObtenerHistorialEntreEquipos_InvalidTeam_ThrowsException() {
        // Given
        String equipo1 = "EquipoInexistente";
        String equipo2 = "River Plate";

        // When & Then
        assertThrows(Exception.class, () -> {
            historialService.obtenerHistorialEntreEquipos(equipo1, equipo2);
        });
    }
}
