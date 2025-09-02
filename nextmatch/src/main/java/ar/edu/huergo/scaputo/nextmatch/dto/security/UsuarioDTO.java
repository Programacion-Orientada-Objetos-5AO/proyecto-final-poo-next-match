package ar.edu.huergo.scaputo.nextmatch.dto.security;

import java.util.List;

public record UsuarioDTO(String username, List<String> roles) {
    
}
