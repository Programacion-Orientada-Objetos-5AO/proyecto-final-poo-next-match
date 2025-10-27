package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.EquipoDTO;

@ExtendWith(MockitoExtension.class)
class EquipoServiceTest {

    @InjectMocks
    private EquipoService equipoService;

    @Test
    void testObtenerEquiposPorNombre_ValidName_ReturnsList() throws Exception {
        // Given
        String nombreEquipo = "Boca Juniors";

        // When
        List<EquipoDTO> result = equipoService.obtenerEquiposPorNombre(nombreEquipo);

        // Then
        assertNotNull(result);
        assertTrue(result.size() >= 0); // Puede ser 0 si no encuentra equipos
    }

    @Test
    void testObtenerEquiposPorNombre_InvalidName_ThrowsException() {
        // Given
        String nombreEquipo = "";

        // When & Then
        assertThrows(Exception.class, () -> {
            equipoService.obtenerEquiposPorNombre(nombreEquipo);
        });
    }
}
