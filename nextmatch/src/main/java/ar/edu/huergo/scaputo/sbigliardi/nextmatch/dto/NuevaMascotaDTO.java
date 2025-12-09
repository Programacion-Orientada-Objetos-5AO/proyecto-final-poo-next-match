package ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
/**
* DTO para transferencia de datos de Producto
* Representa los datos que se exponen en la API REST
*/
public record NuevaMascotaDTO(
    String nombre,
    String tipo,
    Integer edad
) {}
