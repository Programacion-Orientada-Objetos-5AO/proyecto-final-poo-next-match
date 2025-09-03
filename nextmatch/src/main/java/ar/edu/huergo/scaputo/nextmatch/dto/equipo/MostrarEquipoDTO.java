package ar.edu.huergo.scaputo.nextmatch.dto.equipo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * DTO para transferencia de datos de Equipo
 * Representa los datos que se exponen en la API REST
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MostrarEquipoDTO extends EquipoDTO {
}
