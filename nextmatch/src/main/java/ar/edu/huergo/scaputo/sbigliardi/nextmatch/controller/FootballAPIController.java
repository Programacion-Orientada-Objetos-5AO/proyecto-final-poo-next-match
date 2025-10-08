package ar.edu.huergo.scaputo.sbigliardi.nextmatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.FootballAPIDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.FootballAPIService;

@RestController
@RequestMapping("/api")
public class FootballAPIController {

    @Autowired
    private FootballAPIService footballAPIService;

    /**
     * Endpoint para buscar equipos por nombre.
     * Ejemplo: GET http://localhost:8080/api/football/equipos?nombre=Barcelona
     */
    @GetMapping("/equipos")
    public ResponseEntity<List<FootballAPIDTO>> obtenerEquipos(@RequestParam String nombre) {
        try {
            List<FootballAPIDTO> equipos = footballAPIService.obtenerEquiposPorNombre(nombre);
            if (equipos.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(equipos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    } }