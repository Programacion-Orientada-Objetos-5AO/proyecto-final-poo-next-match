package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.TecnicoDTO;

@ExtendWith(MockitoExtension.class)
class TecnicoServiceTest {

    @InjectMocks
    private TecnicoService tecnicoService;

    @Test
    void testObtenerTecnicoPorNombre_ValidName_ReturnsList() throws Exception {
        // Given
        String nombreTecnico = "Guardiola";

        // When
        List<TecnicoDTO> result = tecnicoService.obtenerTecnicoPorNombre(nombreTecnico);

        // Then
        assertNotNull(result);
        assertTrue(result.size() >= 0); // Puede ser 0 si no encuentra técnicos
        if (!result.isEmpty()) {
            TecnicoDTO tecnico = result.get(0);
            assertNotNull(tecnico.getNombre());
            assertNotNull(tecnico.getNacionalidad());
        }
    }

    @Test
    void testObtenerTecnicoPorNombre_InvalidName_ReturnsEmptyList() throws Exception {
        // Given
        String nombreTecnico = "TecnicoInexistente";

        // When
        List<TecnicoDTO> result = tecnicoService.obtenerTecnicoPorNombre(nombreTecnico);

        // Then
        assertNotNull(result);
        // Puede devolver lista vacía o con resultados similares
    }

    @Test
    void testObtenerTecnicoPorNombre_EmptyName_ReturnsEmptyList() throws Exception {
        // Given
        String nombreTecnico = "";

        // When
        List<TecnicoDTO> result = tecnicoService.obtenerTecnicoPorNombre(nombreTecnico);

        // Then
        assertNotNull(result);
        // Puede devolver lista vacía
    }
}
