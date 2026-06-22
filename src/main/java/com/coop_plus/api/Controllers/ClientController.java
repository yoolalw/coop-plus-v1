package com.coop_plus.api.Controllers;

import com.coop_plus.api.Entitys.ClientEntity;
import com.coop_plus.api.Services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/client")
@RestController
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientEntity>> listarClientes(){
        return ResponseEntity.ok(service.listarClientes());
    }

    @PostMapping("/new")
    public ResponseEntity<ClientEntity> cadastrarUsuario(@Valid @RequestBody ClientEntity client){
        return ResponseEntity.ok(service.cadastrarUsuario(client));
    }


}
