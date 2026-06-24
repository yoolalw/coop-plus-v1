package com.coop_plus.api.Services;

import com.coop_plus.api.Entitys.ClientEntity;
import com.coop_plus.api.Repositorys.ClientRepository;
import org.hibernate.annotations.processing.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public List<ClientEntity> listarClientes() {
        Sort sort = Sort.by("nomeCompleto").ascending();
        return repository.findAll(sort);
    }

    public ClientEntity atualizarUsuario(Integer id, ClientEntity clientAtt) {
        ClientEntity exists = repository.findById(id).orElseThrow(NoSuchElementException::new);
        exists.setNomeCompleto(clientAtt.getNomeCompleto());
        exists.setEndereco(clientAtt.getEndereco());
        exists.setEmail(clientAtt.getEmail());
        exists.setSenha(clientAtt.getSenha());
        exists.setCpf(clientAtt.getCpf());
        exists.setTelefone(clientAtt.getCpf());

        return repository.save(exists);
    }
    public void deletarUsuario(Integer id){
        if(!repository.existsById(id)){
            throw new NoSuchElementException("Este usuário nao existe.");
        }
        repository.deleteById(id);
    }
}
