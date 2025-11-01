package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.EstadisticaDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Estadistica;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository.EstadisticaRepository;

@ExtendWith(MockitoExtension.class)
class EstadisticaServiceTest {

    @Mock
    private EstadisticaRepository repository;

    @InjectMocks
    private EstadisticaService service;

    @Test
    void testObtenerEstadisticas_ValidTeamAndLeague_ReturnsDTO() throws Exception {
        String equipo = "Manchester City";
        String liga = "Premier League";
        int temporada = 2023;

        // Creamos el mock usando el constructor con todos los campos
        Estadistica mock = new Estadistica(equipo, liga, temporada);

        when(repository.findByNombreEquipoAndNombreLigaAndTemporada(equipo, liga, temporada))
            .thenReturn(mock);

        EstadisticaDTO result = service.obtenerEstadisticas(equipo, liga, temporada);

        assertNotNull(result);
        assertEquals(equipo, result.getNombreEquipo());
        assertEquals(liga, result.getNombreLiga());
        assertEquals(temporada, result.getTemporada());
    }

    @Test
    void testObtenerEstadisticas_InvalidTeam_ThrowsException() {
        String equipo = "Inexistente";
        String liga = "Premier League";
        int temporada = 2023;

 

        assertThrows(Exception.class, () -> service.obtenerEstadisticas(equipo, liga, temporada));
    }

    @Test
    void testObtenerEstadisticas_InvalidLeague_ThrowsException() {
        String equipo = "Manchester City";
        String liga = "LigaInexistente";
        int temporada = 2023;

        when(repository.findByNombreEquipoAndNombreLigaAndTemporada(equipo, liga, temporada))
            .thenReturn(null);

        assertThrows(Exception.class, () -> service.obtenerEstadisticas(equipo, liga, temporada));
    }

    @Test
    void testObtenerEstadisticas_EmptyTeamName_ThrowsException() {
        String equipo = "";
        String liga = "Premier League";
        int temporada = 2023;

        assertThrows(Exception.class, () -> service.obtenerEstadisticas(equipo, liga, temporada));
    }
}
