package com.coop_plus.api.Services;

import com.coop_plus.api.Entitys.ClientEntity;
import com.coop_plus.api.Repositorys.ClientRepository;
import org.hibernate.annotations.processing.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public List<ClientEntity> listarClientes() {
        Sort sort = Sort.by("nomeCompleto").ascending();
        return repository.findAll(sort);
    }

    public ClientEntity cadastrarUsuario(ClientEntity client) {
        if (repository.existsByEmail(client.getEmail())) {
            throw new IllegalArgumentException();
        }
        
        return repository.save(client);
    }




}
