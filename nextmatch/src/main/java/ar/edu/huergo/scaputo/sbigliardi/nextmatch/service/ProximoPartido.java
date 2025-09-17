package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity.Partido;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProximoPartido {

    private final FootballAPIService apiService = new FootballAPIService();

    public List<Partido> obtenerProximosPartidos(String nombreEquipo, int cantidad) {
        List<Partido> listaPartidos = new ArrayList<>();

        try {
            int teamId = apiService.buscarTeamIdPorNombre(nombreEquipo);
            JSONArray fixtures = apiService.obtenerProximosPartidos(teamId, cantidad);

            for (int i = 0; i < fixtures.length(); i++) {
                JSONObject fixture = fixtures.getJSONObject(i).getJSONObject("fixture");
                JSONObject equipos = fixtures.getJSONObject(i).getJSONObject("teams");

                String fecha = fixture.getString("date");
                String local = equipos.getJSONObject("home").getString("name");
                String visitante = equipos.getJSONObject("away").getString("name");
                String estado = fixture.getJSONObject("status").getString("long");

                listaPartidos.add(new Partido(fecha, local, visitante, estado));
            }

        } catch (Exception e) {
            System.err.println("Error obteniendo partidos: " + e.getMessage());
        }

        return listaPartidos;
    }
}


