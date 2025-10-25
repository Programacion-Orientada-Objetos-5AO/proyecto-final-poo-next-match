package ar.edu.huergo.scaputo.sbigliardi.nextmatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.TecnicoDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.TecnicoService;

@RestController
@RequestMapping("/api/tecnico")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping
    public ResponseEntity<?> buscarPorNombre(@RequestParam String nombre) {
        try {
            List<TecnicoDTO> resultado = tecnicoService.obtenerTecnicoPorNombre(nombre);
            if (resultado.isEmpty()) {
                return ResponseEntity.ok("No se encontró ningún técnico con ese nombre.");
            }
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al obtener datos del técnico.");
        }
    }
}
