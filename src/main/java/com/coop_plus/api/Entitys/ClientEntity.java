package com.coop_plus.api.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Pattern(
            regexp = "^[A-Za-zÀ-ÿ]+(?: [A-Za-zÀ-ÿ]+)*$",
            message = "O nome deve conter apenas letras."
    )
    private String nomeCompleto;

    private String endereco;
    private String email;
    @Pattern(regexp = "^[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][0-9]{2}$", message = "CPF não encontrado.")
    private String cpf;

    @Pattern(regexp = "^[0-9]{2}\s[9]{1}\s[0-9]{4}[-][0-9]{4}$")
    private String telefone;
}
