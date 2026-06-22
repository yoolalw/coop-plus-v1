package com.coop_plus.api.Entitys;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.processing.Pattern;

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
    private String nomeCompleto;

    private String endereco;
    private String email;
    private Integer cpf;
    private Integer telefone;
}
