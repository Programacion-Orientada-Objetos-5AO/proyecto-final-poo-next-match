package ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioInventarioDTO {
    private Long id;
    private String nombre;
    private String categoria;
    private Double precio;
    private Integer stock;
}