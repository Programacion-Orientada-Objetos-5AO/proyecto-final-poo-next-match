package ar.edu.huergo.scaputo.sbigliardi.nextmatch.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Equipo;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Partido;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.EquipoService;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.ProximoPartido;

@RestController
@RequestMapping("/partido")
public class PartidoController {

    private final ProximoPartido proximoPartidoService;
    private final EquipoService equipoService;

    public PartidoController(ProximoPartido proximoPartidoService, EquipoService equipoService) {
        this.proximoPartidoService = proximoPartidoService;
        this.equipoService = equipoService;
    }

    @GetMapping("/proximo/{idEquipo}")
    public ResponseEntity<Partido> obtenerProximoPartido(@PathVariable Long idEquipo) {
        Equipo equipo = equipoService.getEquipoPorId(idEquipo);
        if (equipo == null) {
            return ResponseEntity.notFound().build();
        }
        Partido partido = proximoPartidoService.obtenerProximoPartidoEquipo(equipo);
        if (partido == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(partido);
    }
}
