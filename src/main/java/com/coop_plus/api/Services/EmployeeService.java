package com.coop_plus.api.Services;

import com.coop_plus.api.Entitys.EmployeeEntity;
import com.coop_plus.api.Repositorys.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<EmployeeEntity> listar() {
        Sort sort = Sort.by("tipoServico").ascending();
        return repository.findAll(sort);
    }

    public EmployeeEntity buscarPeloId(Integer id){
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public EmployeeEntity cadastrar(EmployeeEntity employee) {
        if (!repository.existsByEmail(employee.getEmail())) {
            throw new IllegalArgumentException("Este email ja está sendo usado.");
        }
        return repository.save(employee);
    }

    public EmployeeEntity atualizar(Integer id, EmployeeEntity employee) {
        EmployeeEntity exists = repository.findById(id).orElseThrow(NoSuchElementException::new);
        exists.setNomeCompleto(employee.getNomeCompleto());
        exists.setCnpj(employee.getCnpj());
        exists.setNomeEmpresa(employee.getNomeCompleto());
        exists.setEmail(employee.getEmail());
        exists.setDescricao(employee.getDescricao());
        return repository.save(exists);
    }

    public void deletar(Integer id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Este usuario nao existe.");
        }
    }

}
