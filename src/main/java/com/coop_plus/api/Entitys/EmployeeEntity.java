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

    @Pattern(
            regexp = "^[A-Za-zÀ-ÿ]+(?: [A-Za-zÀ-ÿ]+)*$",
            message = "O nome deve conter apenas letras."
    )
    private String nomeCompleto;

    @Pattern(
            regexp = "^[A-Za-zÀ-ÿ]+(?: [A-Za-zÀ-ÿ]+)*$",
            message = "O tipo de serviço só pode ser dito com palavras."
    )
    private String tipoServico;

    private String nomeEmpresa;

    private Boolean favorito;
    private String descricao;

    @Pattern(regexp = "^[0-9]{2}[.][0-9]{3}[.][0-9]{3}[/][0-9]{4}[-][0-9]{2}")
    private String cnpj;

    @Pattern(regexp = "^[0-9]{2}\s[9]{1}\s[0-9]{4}[-][0-9]{4}$")
    private String telefone;


}