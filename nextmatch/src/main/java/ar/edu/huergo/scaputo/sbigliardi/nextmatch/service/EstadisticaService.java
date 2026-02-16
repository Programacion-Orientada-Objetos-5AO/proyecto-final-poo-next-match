package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;

import org.springframework.stereotype.Service;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.EstadisticaDTO;

@Service
public class EstadisticaService {

    private static final String API_KEY = "c9ae24e836d3d8248578568d6d68cce7";
    private static final String BASE_URL = "https://v3.football.api-sports.io/";

    private final HttpClient client = HttpClient.newHttpClient();

    /**
     * Obtiene el ID del equipo según nombre (usa tu método ya hecho)
     */
    private int obtenerIdEquipo(String nombreEquipo) throws Exception {
        String nombreCodificado = URLEncoder.encode(nombreEquipo, StandardCharsets.UTF_8);
        String url = BASE_URL + "teams?name=" + nombreCodificado;

        HttpRequest req = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("x-apisports-key", API_KEY)
            .header("x-apisports-host", "v3.football.api-sports.io")
            .GET()
            .build();

        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(resp.body());
        if (!json.has("response") || json.getJSONArray("response").isEmpty()) {
            throw new RuntimeException("Equipo no encontrado: " + nombreEquipo);
        }
        // suponemos que el primero es el correcto
        return json.getJSONArray("response")
            .getJSONObject(0)
            .getJSONObject("team")
            .getInt("id");
    }

    /**
     * Obtiene el ID de la liga según nombre
     * (suponiendo que hay un endpoint /leagues?name=... similar al de equipos)
     */
    private int obtenerIdLiga(String nombreLiga) throws Exception {
        String cod = URLEncoder.encode(nombreLiga, StandardCharsets.UTF_8);
        String url = BASE_URL + "leagues?name=" + cod;

        HttpRequest req = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("x-apisports-key", API_KEY)
            .header("x-apisports-host", "v3.football.api-sports.io")
            .GET()
            .build();

        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(resp.body());
        if (!json.has("response") || json.getJSONArray("response").isEmpty()) {
            throw new RuntimeException("Liga no encontrada: " + nombreLiga);
        }
        return json.getJSONArray("response")
            .getJSONObject(0)
            .getJSONObject("league")
            .getInt("id");
    }

    public EstadisticaDTO obtenerEstadisticas(String nombreEquipo, String nombreLiga, int temporada) throws Exception {
        int idEquipo = obtenerIdEquipo(nombreEquipo);
        int idLiga = obtenerIdLiga(nombreLiga);

        String url = BASE_URL
            + "teams/statistics?league=" + idLiga
            + "&team=" + idEquipo
            + "&season=" + temporada;

        HttpRequest req = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("x-apisports-key", API_KEY)
            .header("x-apisports-host", "v3.football.api-sports.io")
            .GET()
            .build();

        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(resp.body());

        if (!json.has("response")) {
            throw new RuntimeException("No hay estadísticas para ese equipo / liga / temporada.");
        }

        JSONObject respObj = json.getJSONObject("response");
        JSONObject fixtures = respObj.getJSONObject("fixtures");
        JSONObject wins = fixtures.getJSONObject("wins");
        JSONObject loses = fixtures.getJSONObject("loses");
        JSONObject draws = fixtures.getJSONObject("draws");

        JSONObject goals = respObj.getJSONObject("goals");
        JSONObject goalsFor = goals.getJSONObject("for").getJSONObject("total");
        JSONObject goalsAgainst = goals.getJSONObject("against").getJSONObject("total");

        EstadisticaDTO dto = new EstadisticaDTO();
        dto.setNombreEquipo(nombreEquipo);
        dto.setNombreLiga(nombreLiga);
        dto.setTemporada(temporada);

        dto.setPartidosGanados(wins.getInt("total"));
        dto.setPartidosPerdidos(loses.getInt("total"));
        dto.setPartidosEmpatados(draws.getInt("total"));

        dto.setGolesAFavor(goalsFor.getInt("total"));
        dto.setGolesEnContra(goalsAgainst.getInt("total"));

        return dto;
    }
}
