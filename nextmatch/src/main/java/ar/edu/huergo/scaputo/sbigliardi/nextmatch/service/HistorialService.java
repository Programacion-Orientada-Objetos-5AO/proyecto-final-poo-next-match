package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;


import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class HistorialService {

    private static final String API_KEY = "c9ae24e836d3d8248578568d6d68cce7";
    private static final String BASE_URL = "https://v3.football.api-sports.io/";

    private final HttpClient client = HttpClient.newHttpClient();

    private int obtenerIdEquipo(String nombreEquipo) throws Exception {
        String nombreCodificado = URLEncoder.encode(nombreEquipo, StandardCharsets.UTF_8);
        String url = BASE_URL + "teams?name=" + nombreCodificado;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-apisports-key", API_KEY)
                .header("x-apisports-host", "v3.football.api-sports.io")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(response.body());
        JSONArray arr = json.getJSONArray("response");

        if (arr.isEmpty()) {
            throw new RuntimeException("No se encontró el equipo: " + nombreEquipo);
        }

        return arr.getJSONObject(0).getJSONObject("team").getInt("id");
    }

    // 🔹 Obtiene el historial (head-to-head) entre dos equipos
    public Map<String, Object> obtenerHistorialEntreEquipos(String equipo1, String equipo2) throws Exception {
        int id1 = obtenerIdEquipo(equipo1);
        int id2 = obtenerIdEquipo(equipo2);

        String url = BASE_URL + "fixtures/headtohead?h2h=" + id1 + "-" + id2;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-apisports-key", API_KEY)
                .header("x-apisports-host", "v3.football.api-sports.io")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(response.body());
        JSONArray matches = json.getJSONArray("response");

        int ganados1 = 0;
        int ganados2 = 0;
        int empatados = 0;

        for (int i = 0; i < matches.length(); i++) {
            JSONObject fixture = matches.getJSONObject(i).getJSONObject("teams");
            JSONObject home = fixture.getJSONObject("home");
            JSONObject away = fixture.getJSONObject("away");

            Boolean winnerHome = home.isNull("winner") ? null : home.getBoolean("winner");
            Boolean winnerAway = away.isNull("winner") ? null : away.getBoolean("winner");

            if (Boolean.TRUE.equals(winnerHome)) ganados1++;
            else if (Boolean.TRUE.equals(winnerAway)) ganados2++;
            else empatados++;
        }

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("equipo1", equipo1);
        resultado.put("equipo2", equipo2);
        resultado.put("ganados1", ganados1);
        resultado.put("empatados", empatados);
        resultado.put("ganados2", ganados2);

        return resultado;
    }
}
