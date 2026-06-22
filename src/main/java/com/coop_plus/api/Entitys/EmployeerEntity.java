package com.coop_plus.api.Entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employeers")
public class EmployeerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(nullable = false, name = "nome")
    private String nomeCompleto;

    @Column(nullable = false, name = "servico")
    private String tipoServico;

    @Column(nullable = true, name = "empresa")
    private String nomeEmpresa;

    private Boolean favorito;

    private String descricao;
    private Integer cnpj;
    private Integer telefone;


}