package ar.edu.huergo.scaputo.sbigliardi.nextmatch.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.EquipoDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Equipo;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.EquipoService;

@WebMvcTest(EquipoController.class)
public class EquipoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EquipoService equipoService;

    @Test
    public void testGetEquipos() throws Exception {
        EquipoDTO equipo1 = new EquipoDTO(1L, "Equipo A");
        EquipoDTO equipo2 = new EquipoDTO(2L, "Equipo B");
        when(equipoService.getEquipos()).thenReturn(Arrays.asList(equipo1, equipo2));

        mockMvc.perform(get("/equipo"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Equipo A"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].nombre").value("Equipo B"));
    }

    @Test
    public void testGetEquipo() throws Exception {
        Equipo equipo = new Equipo(1L, "Equipo A");
        when(equipoService.getEquipo(1L)).thenReturn(Optional.of(equipo));

        mockMvc.perform(get("/equipo/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Equipo A"));
    }

    @Test
    public void testGetEquipoNotFound() throws Exception {
        when(equipoService.getEquipo(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/equipo/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCrearEquipo() throws Exception {
        String equipoJson = "{\"nombre\":\"Nuevo Equipo\"}";

        mockMvc.perform(post("/equipo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(equipoJson))
                .andExpect(status().isCreated())
                .andExpect(content().string("Equipo creado correctamente"));

        verify(equipoService).crearEquipo(any(EquipoDTO.class));
    }

    @Test
    public void testActualizarEquipo() throws Exception {
        String equipoJson = "{\"nombre\":\"Equipo Actualizado\"}";

        mockMvc.perform(put("/equipo/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(equipoJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Equipo actualizado correctamente"));

        verify(equipoService).actualizarEquipo(eq(1L), any(EquipoDTO.class));
    }

    @Test
    public void testEliminarEquipo() throws Exception {
        mockMvc.perform(delete("/equipo/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Equipo eliminado correctamente"));

        verify(equipoService).eliminarEquipo(1L);
    }
}
