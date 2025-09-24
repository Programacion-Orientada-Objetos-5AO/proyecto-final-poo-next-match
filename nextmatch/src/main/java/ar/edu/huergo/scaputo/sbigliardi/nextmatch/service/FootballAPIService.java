package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service // <- <--- Esto lo convierte en bean
public class FootballAPIService {

    private static final String API_KEY = "c9ae24e836d3d8248578568d6d68cce7";
    private static final String BASE_URL = "https://v3.football.api-sports.io";
    private final HttpClient client = HttpClient.newHttpClient();

    public int buscarTeamIdPorNombre(String nombreEquipo) throws Exception {
        String url = BASE_URL + "/teams?search=" + nombreEquipo;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-apisports-key", API_KEY)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(response.body());

        JSONArray equipos = json.getJSONArray("response");

        if (equipos.length() == 0) {
            throw new Exception("Equipo no encontrado: " + nombreEquipo);
        }

        JSONObject equipo = equipos.getJSONObject(0).getJSONObject("team");
        return equipo.getInt("id");
    }

    public JSONArray obtenerProximosPartidos(int teamId, int cantidad) throws Exception {
        String url = BASE_URL + "/fixtures?team=" + teamId + "&next=" + cantidad;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-apisports-key", API_KEY)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(response.body());

        return json.getJSONArray("response");
    }
}
