package com.coop_plus.api.Controllers;

import com.coop_plus.api.Dtos.AuthenticationDTO;
import com.coop_plus.api.Dtos.ClientDTO;
import com.coop_plus.api.Entitys.ClientEntity;
import com.coop_plus.api.Repositorys.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok().build();

    }

    @PostMapping("/newClient")
    public ResponseEntity<ClientEntity> cadastrarCliente(@Valid @RequestBody ClientDTO client) {
        if (this.clientRepository.findByEmail(client.email()) != null) return ResponseEntity.badRequest().build();
        String bcrypt = new BCryptPasswordEncoder().encode(client.senha());
        ClientEntity clientEntity = new ClientEntity(client.email(), bcrypt, client.role());
        this.clientRepository.save(clientEntity);
        return ResponseEntity.ok().build();
    }
}
