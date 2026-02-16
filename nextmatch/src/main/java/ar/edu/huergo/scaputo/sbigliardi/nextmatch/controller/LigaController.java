package ar.edu.huergo.scaputo.sbigliardi.nextmatch.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.LigaService;

@RestController
@RequestMapping("/api")
public class LigaController {

    @Autowired
    private LigaService ligaService;
    /**
     * GET http://localhost:8080/api/liga?nombre=la liga&temporada=2022&pais=Spain
     */
    @GetMapping("/liga")
    public ResponseEntity<Map<String, Object>> obtenerEquiposPorLiga(
            @RequestParam String nombre,
            @RequestParam int temporada,
            @RequestParam String pais) {

        try {
            Map<String, Object> resultado = ligaService.obtenerEquiposPorLiga(nombre, temporada, pais);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
