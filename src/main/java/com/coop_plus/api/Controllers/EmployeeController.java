package com.coop_plus.api.Controllers;

import com.coop_plus.api.Entitys.EmployeeEntity;
import com.coop_plus.api.Services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employes")
@CrossOrigin(origins = "*")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("/newEmployee")
    public ResponseEntity<EmployeeEntity> cadastrar(@Valid @RequestBody EmployeeEntity employee){
        return ResponseEntity.ok(service.cadastrar(employee));
    }

    @PutMapping("/attEmployee/{id}")
    public ResponseEntity<EmployeeEntity> atualizar(@PathVariable Integer id, @RequestBody EmployeeEntity employee){
        return ResponseEntity.ok(service.atualizar(id, employee));
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deletar(@PathVariable Integer id){
        service.deletar(id);
    }

}
