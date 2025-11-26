package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.LibroRequestDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.LibroResponseDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Libro;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.mapper.LibroMapper;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.repository.LibroRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {

    private final LibroRepository repository;
    private final LibroMapper mapper;

    public LibroService(LibroRepository repository, LibroMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public LibroResponseDTO crear(LibroRequestDTO dto) {
        Libro libro = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(libro));
    }

    public List<LibroResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public LibroResponseDTO obtenerPorId(Long id) {
        Libro libro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrada con id: " + id));

        return mapper.toDTO(libro);
    }

    public LibroResponseDTO actualizar(Long id, LibroRequestDTO dto) {
        Libro libro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrada con id: " + id));

        libro.setTituloLibro(dto.getTituloLibro());
        libro.setNombreUsuario(dto.getNombreUsuario());
        libro.setFechaDevolucion(libro.getFechaPrestamo().plusDays(dto.getDiasPrestamo()));
       
      

        return mapper.toDTO(repository.save(libro));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}


