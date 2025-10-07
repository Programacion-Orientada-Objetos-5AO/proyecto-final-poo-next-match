package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service

public class FootballAPIService {

    private static final String API_KEY = "c9ae24e836d3d8248578568d6d68cce7"; 
    private static final String BASE_URL = "https://v3.football.api-sports.io/teams?name=";

    public JSONArray obtenerProximosPartidos(int teamId, int cantidad) throws Exception {
        String url = BASE_URL + "?team=" + teamId + "&next=" + cantidad;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-apisports-key", API_KEY)
                .header("x-apisports-host", "v3.football.api-sports.io")
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());
        return json.getJSONArray("response");
    }
}