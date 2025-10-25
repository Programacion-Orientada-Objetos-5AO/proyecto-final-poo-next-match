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

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.EquipoDTO;

@Service
public class TecnicoService {

    private static final String API_KEY = "c9ae24e836d3d8248578568d6d68cce7";
    private static final String BASE_URL = "https://v3.football.api-sports.io/";

    public List<EquipoDTO> obtenerEquiposPorNombre(String nombreTecnico) throws Exception {
        String nombreCodificado = URLEncoder.encode(nombreTecnico, StandardCharsets.UTF_8);
        String url = BASE_URL + "coachs?search=" + nombreCodificado;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-apisports-key", API_KEY)
                .header("x-apisports-host", "v3.football.api-sports.io")
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());
        JSONArray equiposArray = json.getJSONArray("response");

        List<EquipoDTO> equipos = new ArrayList<>();

        for (int i = 0; i < equiposArray.length(); i++) {
           

            EquipoDTO dto = new EquipoDTO();
            dto.setNombre(equipoObj.getString("name"));
            dto.setPais(equipoObj.getString("nacionality"));
            dto.setFundacion(equipoObj.getInt("team"));
            dto.setLogo(equipoObj.getString("age"));


            equipos.add(dto);
        }

        return equipos;
    }
}