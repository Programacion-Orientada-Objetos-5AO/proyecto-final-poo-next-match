package ar.edu.huergo.scaputo.sbigliardi.nextmatch.controller;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService service;

    @Autowired
    private MascotaMapper mapper;

    @PostMapping
    public ResponseEntity<MascotaDTO> crear(@RequestBody NuevaMascotaDTO dto) {
        Mascota guardada = service.crear(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(guardada));
    }

    @GetMapping
    public ResponseEntity<List<MascotaDTO>> obtenerTodos() {
        return ResponseEntity.ok(
            service.obtenerTodos().stream().map(mapper::toDTO).toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDTO(service.obtenerPorId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MascotaDTO> actualizar(
            @PathVariable Long id,
            @RequestBody NuevaMascotaDTO dto) {

        Mascota actualizada = service.actualizar(id, mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(actualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
