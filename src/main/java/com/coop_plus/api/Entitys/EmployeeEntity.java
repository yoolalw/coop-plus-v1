package com.coop_plus.api.Entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "employeers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Pattern(regexp = "^[a-z]+/i$", message="O nome deve conter apenas letras.")
    private String nomeCompleto;

    private String tipoServico;
    private String nomeEmpresa;
    private Boolean favorito;
    private String descricao;
    private Integer cnpj;
    private Integer telefone;


}