package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.usuario.AutenticacaoPostDto;
import med.voll.api.domain.usuario.Usuario;
import med.voll.api.infra.security.TokenJWTDto;
import med.voll.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid AutenticacaoPostDto autenticacaoDto) {
        var authToken = new UsernamePasswordAuthenticationToken(autenticacaoDto.login(), autenticacaoDto.senha());
        var auth = manager.authenticate(authToken);

        var tokenJWT = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new TokenJWTDto(tokenJWT));
    }
}
