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

import ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.UsuarioInventarioDTO;

@Service
public class UsuarioIneventarioService {

    private static final String API_KEY = "c9ae24e836d3d8248578568d6d68cce7";
    private static final String BASE_URL = "https://v3.football.api-sports.io/";


    public List<UsuarioInventarioDTO> obtenerUsuariosPorNombre(String nombreUsuario) throws Exception {
        String nombreCodificado = URLEncoder.encode(nombreUsuario, StandardCharsets.UTF_8);
        String url = BASE_URL + "users?name=" + nombreCodificado;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-apisports-key", API_KEY)
                .header("x-apisports-host", "v3.football.api-sports.io")
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());
        JSONArray usuariosArray = json.getJSONArray("response");

        List<UsuarioInventarioDTO> usuarios = new ArrayList<>();

        for (int i = 0; i < usuariosArray.length(); i++) {
            JSONObject usuarioObj = usuariosArray.getJSONObject(i).getJSONObject("user");

            UsuarioInventarioDTO dto = new UsuarioInventarioDTO();
            dto.setId(usuarioObj.getLong("id"));
            dto.setNombre(usuarioObj.getString("name"));
            dto.setCategoria(usuarioObj.getString("categoria"));
            dto.setPrecio(usuarioObj.getDouble("precio"));
            dto.setStock(usuarioObj.getInt("stock"));

            usuarios.add(dto);
        }

        return usuarios;
    }
}

