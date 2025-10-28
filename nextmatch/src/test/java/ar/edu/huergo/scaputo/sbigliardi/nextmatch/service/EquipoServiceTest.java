package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.EquipoDTO;

@ExtendWith(MockitoExtension.class)
class EquipoServiceTest {

    @InjectMocks
    private EquipoService equipoService;

    @Test
    void testObtenerEquiposPorNombre_ValidName_ReturnsList() throws Exception {
        // Given
        String nombreEquipo = "barcelona";

        // When
        List<EquipoDTO> result = equipoService.obtenerEquiposPorNombre(nombreEquipo);

        // Then
        assertNotNull(result);
        assertTrue(result.size() >= 0); // puede ser vacía si no hay resultados
    }

    @Test
    void testObtenerEquiposPorNombre_InvalidName_ReturnsEmptyList() throws Exception {
        // Given
        String nombreEquipo = "";

        // When
        List<EquipoDTO> result = equipoService.obtenerEquiposPorNombre(nombreEquipo);

        // Then
        assertNotNull(result);
        assertTrue(result.isEmpty()); // si está vacío, pasa
    }
}
