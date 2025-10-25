package ar.edu.huergo.scaputo.sbigliardi.nextmatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.EstadisticaDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.EstadisticaService;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticaController {

    @Autowired
    private EstadisticaService estadisticaService;

    @GetMapping
    public ResponseEntity<?> getEstadisticas(
            @RequestParam String equipo,
            @RequestParam String liga,
            @RequestParam int temporada) {

        try {
            EstadisticaDTO dto = estadisticaService.obtenerEstadisticas(equipo, liga, temporada);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("{\"error\": \"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("{\"error\": \"Error interno al consultar estadísticas\"}");
        }
    }
}

