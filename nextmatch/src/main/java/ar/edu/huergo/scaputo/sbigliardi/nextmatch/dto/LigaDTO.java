package ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LigaDTO {

    private String nombre;
    private int temporada;
    private List<String> equipos;
}
