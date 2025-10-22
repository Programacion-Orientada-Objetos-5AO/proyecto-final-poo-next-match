package ar.edu.huergo.scaputo.sbigliardi.nextmatch.service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class LigaService {

    private static final String API_KEY = "c9ae24e836d3d8248578568d6d68cce7";
    private static final String BASE_URL = "https://v3.football.api-sports.io/";

    private final HttpClient client = HttpClient.newHttpClient();

    /**
     * 🔹 Obtiene el ID de la liga según el nombre, temporada y país.
     */
    private int obtenerIdLiga(String nombreLiga, int temporada, String pais) throws Exception {
        String nombreCodificado = URLEncoder.encode(nombreLiga, StandardCharsets.UTF_8);
        String paisCodificado = URLEncoder.encode(pais, StandardCharsets.UTF_8);

        String url = BASE_URL + "leagues?name=" + nombreCodificado + "&season=" + temporada + "&country=" + paisCodificado;

        System.out.println("🔍 URL buscada: " + url);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-apisports-key", API_KEY)
                .header("x-apisports-host", "v3.football.api-sports.io")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("📥 Respuesta completa:");
        System.out.println(response.body());

        JSONObject json = new JSONObject(response.body());
        JSONArray arr = json.getJSONArray("response");

        if (arr.isEmpty()) {
            throw new RuntimeException("⚠️ No se encontró la liga '" + nombreLiga + "' en " + pais + " para la temporada " + temporada);
        }

        // Buscamos el match exacto de nombre y país
        for (int i = 0; i < arr.length(); i++) {
            JSONObject ligaObj = arr.getJSONObject(i).getJSONObject("league");
            String nombre = ligaObj.getString("name");
            String paisLiga = arr.getJSONObject(i).getJSONObject("country").getString("name");

            if (nombre.equalsIgnoreCase(nombreLiga) && paisLiga.equalsIgnoreCase(pais)) {
                int id = ligaObj.getInt("id");
                System.out.println("✅ ID de liga encontrado: " + id);
                return id;
            }
        }

        throw new RuntimeException("⚠️ No se encontró la liga '" + nombreLiga + "' en " + pais + " para la temporada " + temporada);
    }

    /**
     * 🔹 Obtiene los equipos participantes de una liga y temporada.
     */
    public Map<String, Object> obtenerEquiposPorLiga(String nombreLiga, int temporada, String pais) throws Exception {
        int idLiga = obtenerIdLiga(nombreLiga, temporada, pais);

        String url = BASE_URL + "teams?league=" + idLiga + "&season=" + temporada;
        System.out.println("📡 Consultando equipos con URL: " + url);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-apisports-key", API_KEY)
                .header("x-apisports-host", "v3.football.api-sports.io")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(response.body());
        JSONArray arr = json.getJSONArray("response");

        List<String> equipos = new ArrayList<>();

        for (int i = 0; i < arr.length(); i++) {
            JSONObject teamObj = arr.getJSONObject(i).getJSONObject("team");
            equipos.add(teamObj.getString("name"));
        }

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("liga", nombreLiga);
        resultado.put("temporada", temporada);
        resultado.put("pais", pais);
        resultado.put("equipos", equipos);

        System.out.println("🏁 Equipos encontrados: " + equipos.size());

        return resultado;
    }
}
    