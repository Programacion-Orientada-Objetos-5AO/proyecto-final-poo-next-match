package ar.edu.huergo.scaputo.nextmatch.dto.equipo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para transferencia de datos de Equipo
 * Representa los datos que se exponen en la API REST
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class EquipoDTO {
    Long id;
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    String nombre;
    String descripcion;
    @Positive(message = "El precio debe ser positivo")
    @NotNull(message = "El precio no puede ser nulo")
    Double precio;
}