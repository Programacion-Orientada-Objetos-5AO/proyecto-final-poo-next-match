package ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
* DTO para transferencia de datos de Refugio
* Representa los datos que se exponen en la API REST
*/
public record MascotaDTO(
// El id puede ser nulo en creación; se completa al persistir
Long id,
// No permite vacío o solo espacios y exige un rango de longitud
@NotBlank(message = "El nombre es obligatorio")
@Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
String nombre,

@Positive (message = "Debe ser positivo")
int edad,
@NotBlank(message = "El tipo es obligatorio")
@Size(min = 2, max = 100, message = "El tipo (perro, gato, conejo, etc) debe tener entre 2 y 100 caracteres")
String tipo,
@Min(value = 1, message = "La respuesta debe ser si o no")
boolean adoptado //EN EL DTO ESTE NO PUEDE SER PRIVATE

) {
}