package com.coop_plus.api.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class ClientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Pattern(regexp = "^[a-z]+/i$", message = "O nome deve conter apenas letras.")
    private String nomeCompleto;

    private String endereco;
    private String email;
    private Integer cpf;
    private Integer telefone;
}
