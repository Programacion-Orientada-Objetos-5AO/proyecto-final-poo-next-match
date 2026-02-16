package ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistorialDTO {

    private String equipo1;
    private String equipo2;

    private int ganados1;
    private int empatados;
    private int ganados2;
}
