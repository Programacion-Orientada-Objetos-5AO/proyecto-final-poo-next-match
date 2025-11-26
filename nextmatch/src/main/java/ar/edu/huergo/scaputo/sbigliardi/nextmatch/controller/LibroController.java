package ar.edu.huergo.scaputo.sbigliardi.nextmatch.controller;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.LibroRequestDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.LibroResponseDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    @PostMapping
    public LibroResponseDTO crear(@RequestBody LibroRequestDTO dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<LibroResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public LibroResponseDTO obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }
    
    @PutMapping("/{id}")
    public LibroResponseDTO actualizar(@PathVariable Long id,
                                        @RequestBody LibroRequestDTO dto) {
        return service.actualizar(id, dto);
    }
    
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
