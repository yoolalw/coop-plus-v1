package com.coop_plus.api.Entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="clients")
public class ClientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(nullable = false, name = "nome")
    private String nomeCompleto;

    private String endereco;
    private String email;
    private Integer cpf;
    private Integer telefone;
}
