package com.coop_plus.api.Controllers;

import com.coop_plus.api.Dtos.AuthenticationDTO;
import com.coop_plus.api.Dtos.ClientDTO;
import com.coop_plus.api.Dtos.LoginResponseDTO;
import com.coop_plus.api.Entitys.ClientEntity;
import com.coop_plus.api.Repositorys.ClientRepository;
import com.coop_plus.api.Security.TokenService;
import jakarta.validation.Valid;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")

public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((ClientEntity) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));

    }

    @PostMapping("/newClient")
    public ResponseEntity<ClientEntity> cadastrarCliente(@Valid @RequestBody ClientDTO client) {
        if (this.clientRepository.findByEmail(client.email()) != null) return ResponseEntity.badRequest().build();
        String bcrypt = new BCryptPasswordEncoder().encode(client.senha());
        ClientEntity clientEntity = new ClientEntity(client.nomeCompleto(), client.endereco(), client.email(), bcrypt, client.cpf(), client.telefone(), client.role());
        this.clientRepository.save(clientEntity);
        System.out.println(client);
        return ResponseEntity.ok().build();
    }
}
