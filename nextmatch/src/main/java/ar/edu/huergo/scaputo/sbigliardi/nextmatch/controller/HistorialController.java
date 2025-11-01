package ar.edu.huergo.scaputo.sbigliardi.nextmatch.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.HistorialService;

@RestController
@RequestMapping("/api")
public class HistorialController {

    @Autowired
    private HistorialService HistorialService;

    /**
     * GET http://localhost:8080/api/h2h?equipo1=manchester united&equipo2=liverpool
     */
    @GetMapping("/h2h")
    public ResponseEntity<Map<String, Object>> obtenerHistorialEntreEquipos(
            @RequestParam String equipo1,
            @RequestParam String equipo2) {

        try {
            Map<String, Object> resultado = HistorialService.obtenerHistorialEntreEquipos(equipo1, equipo2);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
