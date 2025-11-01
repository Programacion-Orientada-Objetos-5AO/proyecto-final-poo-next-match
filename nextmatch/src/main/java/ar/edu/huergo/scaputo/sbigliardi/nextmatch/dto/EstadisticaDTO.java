package ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadisticaDTO {
    private String nombreEquipo;
    private String nombreLiga;
    private int temporada;

    private int partidosGanados;
    private int partidosPerdidos;
    private int partidosEmpatados;

    private int golesAFavor;
    private int golesEnContra;
}
