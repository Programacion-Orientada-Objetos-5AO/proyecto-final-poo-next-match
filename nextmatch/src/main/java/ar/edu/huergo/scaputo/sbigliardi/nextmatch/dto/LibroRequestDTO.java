package ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data

@NoArgsConstructor
@AllArgsConstructor
public class LibroRequestDTO {
    private String tituloLibro;
    private String nombreUsuario;
    private int diasPrestamo;
}
