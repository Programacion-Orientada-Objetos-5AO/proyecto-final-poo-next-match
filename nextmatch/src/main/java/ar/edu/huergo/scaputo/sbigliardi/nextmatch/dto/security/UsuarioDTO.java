package ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto.security;

import java.util.List;

public record UsuarioDTO(String username, List<String> roles) {
    
}
