package ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FootballAPIDTO {
    private int id;
    private String nombre;
    private String pais;
    private int fundacion;
    private String logo;
    private String estadio;
    private String direccionEstadio;
    private String ciudad;
    private int capacidadEstadio;
}

