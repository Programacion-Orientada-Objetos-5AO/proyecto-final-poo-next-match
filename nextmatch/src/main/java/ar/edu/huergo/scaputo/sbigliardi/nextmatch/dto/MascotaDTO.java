package ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto;

public record MascotaDTO(
    Long id,
    String nombre,
    String tipo,
    Integer edad,
    Boolean adoptado
) {}
