package ar.edu.huergo.scaputo.sbigliardi.nextmatch.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.EquipoDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Equipo;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.EquipoService;

@RestController
@RequestMapping("/equipo")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public List<EquipoDTO> getEquipos() {
        return equipoService.getEquipos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoDTO> getEquipo(@PathVariable Long id) {
        Equipo equipo = equipoService.getEquipoPorId(id);
        if (equipo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new EquipoDTO(equipo.getId(), equipo.getNombre()));
    }
}
