package ar.edu.huergo.scaputo.sbigliardi.nextmatch.mapper;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.LibroRequestDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.LibroResponseDTO;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Libro;

@Component
public class LibroMapper {

    public Libro toEntity(LibroRequestDTO dto) {
        
        LocalDate fechaPrestamo = LocalDate.now();
        LocalDate fechaDevolucion = fechaPrestamo.plusDays(dto.getDiasPrestamo());
        Libro e = new Libro();
        e.setTituloLibro(dto.getTituloLibro());
        e.setNombreUsuario(dto.getNombreUsuario());
        e.setFechaPrestamo(fechaPrestamo);
        e.setFechaDevolucion(fechaDevolucion);
        e.setDevuelto(false);        
        return e;
    }

    public LibroResponseDTO toDTO(Libro e) {
        LibroResponseDTO dto = new LibroResponseDTO();
        dto.setId(e.getId());
        dto.setTituloLibro(e.getTituloLibro());
        dto.setNombreUsuario(e.getNombreUsuario());
        dto.setFechaPrestamo(e.getFechaPrestamo());
        dto.setFechaDevolucion(e.getFechaDevolucion());
        dto.setDevuelto(false);
        return dto;
    }
}
