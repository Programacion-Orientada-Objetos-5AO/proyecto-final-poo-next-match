package ar.edu.huergo.scaputo.sbigliardi.nextmatch.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.EquipoDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Equipo;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Partido;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.EquipoService;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.ProximoPartido;

@RestController
@RequestMapping("/equipo")
public class EquipoController {

    private final EquipoService equipoService;
    private final ProximoPartido proximoPartido;

    public EquipoController(EquipoService equipoService, ProximoPartido proximoPartido) {
        this.equipoService = equipoService;
        this.proximoPartido = proximoPartido;
    }

    @GetMapping
    public List<EquipoDTO> getEquipos() {
        return equipoService.getEquipos();
    }

    @GetMapping("/{index}/proximo-partido")
    public ResponseEntity<Partido> getProximoPartido(@PathVariable int index) {
        Equipo equipo = equipoService.getEquipoPorId(index);

        if (equipo == null) return ResponseEntity.notFound().build();

        Partido partido = proximoPartido.obtenerProximoPartidoEquipo(equipo);

        if (partido == null) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(partido);
    }

}
