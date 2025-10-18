package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.FootballAPIDTO;

@Service
public class FootballAPIService {

    private static final String API_KEY = "c9ae24e836d3d8248578568d6d68cce7";
    private static final String BASE_URL = "https://v3.football.api-sports.io/";

    public List<FootballAPIDTO> obtenerEquiposPorNombre(String nombreEquipo) throws Exception {
        String nombreCodificado = URLEncoder.encode(nombreEquipo, StandardCharsets.UTF_8);
        String url = BASE_URL + "teams?name=" + nombreCodificado;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-apisports-key", API_KEY)
                .header("x-apisports-host", "v3.football.api-sports.io")
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());
        JSONArray equiposArray = json.getJSONArray("response");

        List<FootballAPIDTO> equipos = new ArrayList<>();

        for (int i = 0; i < equiposArray.length(); i++) {
            JSONObject equipoObj = equiposArray.getJSONObject(i).getJSONObject("team");
            JSONObject estadioObj = equiposArray.getJSONObject(i).getJSONObject("venue");

            FootballAPIDTO dto = new FootballAPIDTO();
            dto.setId(equipoObj.getInt("id"));
            dto.setNombre(equipoObj.getString("name"));
            dto.setPais(equipoObj.getString("country"));
            dto.setFundacion(equipoObj.getInt("founded"));
            dto.setLogo(equipoObj.getString("logo"));

            dto.setEstadio(estadioObj.getString("name"));
            dto.setDireccionEstadio(estadioObj.optString("address", "N/A"));
            dto.setCiudad(estadioObj.optString("city", "N/A"));
            dto.setCapacidadEstadio(estadioObj.optInt("capacity", 0));

            equipos.add(dto);
        }

        return equipos;
    }
}

