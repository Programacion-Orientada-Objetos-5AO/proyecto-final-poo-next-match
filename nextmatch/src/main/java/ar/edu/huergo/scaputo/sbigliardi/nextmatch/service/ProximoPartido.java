package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Equipo;
import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Partido;

@Service
public class ProximoPartido {

    private final FootballAPIService apiService;

    public ProximoPartido(FootballAPIService apiService) {
        this.apiService = apiService;
    }

    public Partido obtenerProximoPartidoEquipo(Equipo equipo) {
        try {
            int teamId = equipo.getApiId();
            JSONArray fixtures = apiService.obtenerProximosPartidos(teamId, 1); // solo el próximo partido

            if (fixtures.length() == 0) return null;

            JSONObject fixture = fixtures.getJSONObject(0).getJSONObject("fixture");
            JSONObject equipos = fixtures.getJSONObject(0).getJSONObject("teams");

            String fecha = fixture.getString("date");
            String local = equipos.getJSONObject("home").getString("name");
            String visitante = equipos.getJSONObject("away").getString("name");
            String estado = fixture.getJSONObject("status").getString("long");

            return new Partido(fecha, local, visitante, estado);

        } catch (Exception e) {
            System.err.println("Error obteniendo partidos: " + e.getMessage());
            return null;
        }
    }
}



