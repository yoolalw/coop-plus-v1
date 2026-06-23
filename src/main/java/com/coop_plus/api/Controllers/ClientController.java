package com.coop_plus.api.Controllers;

import com.coop_plus.api.Entitys.ClientEntity;
import com.coop_plus.api.Entitys.UserRole;
import com.coop_plus.api.Services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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


    @PutMapping("/att/{id}")
    public ResponseEntity<ClientEntity> atualizarCliente(@PathVariable Integer id, @RequestBody ClientEntity client){
        return ResponseEntity.ok(service.atualizarUsuario(id, client));
    }

    @DeleteMapping("/del/{id}")
    public void deletarCliente(@PathVariable Integer id){
        service.deletarUsuario(id);
    }

}
