package ar.edu.huergo.scaputo.sbigliardi.nextmatch.controller;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.PartidoDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Partido;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.ProximoPartido;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    private final ProximoPartido proximoPartidoService;

    public PartidoController(ProximoPartido proximoPartidoService) {
        this.proximoPartidoService = proximoPartidoService;
    }

    /**
     * Devuelve una lista con los próximos partidos de un equipo
     */
    @GetMapping("/proximos/{nombreEquipo}")
    public List<PartidoDTO> getProximosPartidos(
            @PathVariable String nombreEquipo,
            @RequestParam(defaultValue = "1") int cantidad) {

        List<Partido> partidos = proximoPartidoService.obtenerProximosPartidos(nombreEquipo, cantidad);

        return partidos.stream()
                .map(p -> new PartidoDTO(p.getFecha(), p.getLocal(), p.getVisitante(), p.getEstado()))
                .collect(Collectors.toList());
    }

    /**
     * Devuelve solo el próximo partido del equipo
     */
    @GetMapping("/proximo/{nombreEquipo}")
    public PartidoDTO getProximoPartido(@PathVariable String nombreEquipo) {
        List<Partido> partidos = proximoPartidoService.obtenerProximosPartidos(nombreEquipo, 1);

        if (partidos.isEmpty()) {
            return new PartidoDTO("N/A", "N/A", "N/A", "Sin partidos próximos");
        }

        Partido p = partidos.get(0);
        return new PartidoDTO(p.getFecha(), p.getLocal(), p.getVisitante(), p.getEstado());
    }
}
