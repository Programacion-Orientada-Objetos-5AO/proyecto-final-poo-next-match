package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.EquipoDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Equipo;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository.EquipoRepository;

@ExtendWith(MockitoExtension.class)
public class EquipoServiceTest {

    @Mock
    private EquipoRepository equipoRepository;

    @InjectMocks
    private EquipoService equipoService;

    @Test
    public void testGetEquipos() {
        Equipo equipo1 = new Equipo(1L, "Equipo A");
        Equipo equipo2 = new Equipo(2L, "Equipo B");
        when(equipoRepository.findAll()).thenReturn(Arrays.asList(equipo1, equipo2));

        List<EquipoDTO> result = equipoService.getEquipos();

        assertEquals(2, result.size());
        assertEquals("Equipo A", result.get(0).nombre());
        assertEquals("Equipo B", result.get(1).nombre());
    }

    @Test
    public void testGetEquipo() {
        Equipo equipo = new Equipo(1L, "Equipo A");
        when(equipoRepository.findById(1L)).thenReturn(Optional.of(equipo));

        Optional<Equipo> result = equipoService.getEquipo(1L);

        assertTrue(result.isPresent());
        assertEquals("Equipo A", result.get().getNombre());
    }

    @Test
    public void testCrearEquipo() {
        EquipoDTO equipoDTO = new EquipoDTO(null, "Nuevo Equipo");

        equipoService.crearEquipo(equipoDTO);

        verify(equipoRepository).save(any(Equipo.class));
    }

    @Test
    public void testActualizarEquipo() throws NotFoundException {
        Equipo equipo = new Equipo(1L, "Equipo A");
        EquipoDTO equipoDTO = new EquipoDTO(1L, "Equipo Actualizado");
        when(equipoRepository.findById(1L)).thenReturn(Optional.of(equipo));

        equipoService.actualizarEquipo(1L, equipoDTO);

        verify(equipoRepository).save(equipo);
        assertEquals("Equipo Actualizado", equipo.getNombre());
    }

    @Test
    public void testActualizarEquipoNotFound() {
        EquipoDTO equipoDTO = new EquipoDTO(1L, "Equipo Actualizado");
        when(equipoRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> equipoService.actualizarEquipo(1L, equipoDTO));
    }

    @Test
    public void testEliminarEquipo() {
        equipoService.eliminarEquipo(1L);

        verify(equipoRepository).deleteById(1L);
    }
}
