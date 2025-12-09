package ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record MascotaDTO(
    Long id,
    String nombre,
    String tipo,
    Integer edad,
    Boolean adoptado
) {}
