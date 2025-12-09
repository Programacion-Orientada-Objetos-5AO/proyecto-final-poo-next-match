package ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
/**
REVISAR SI TENGO QUE BORRAR LOS IMPORT
*/
public record NuevaMascotaDTO(
    String nombre,
    String tipo,
    Integer edad
) {}
