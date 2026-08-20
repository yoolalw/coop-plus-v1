package com.coop_plus.api.Entitys;

import com.coop_plus.api.Dtos.ClientDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "idUser")
public class ClientEntity extends UserEntity {
    @Pattern(regexp = "^[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][0-9]{2}$", message = "CPF não encontrado.")
    private String cpf;
    private String endereco;

    private Integer avaliacoes;

    public ClientEntity(String nomeCompleto, String email, String senha,
                        String descricao, String telefone, UserRole role, String cpf, String endereco, Integer avaliacoes){
        super(nomeCompleto, email, senha, descricao, telefone, role);
        this.cpf = cpf;
        this.endereco = endereco;
        this.avaliacoes = avaliacoes;

    }

}
