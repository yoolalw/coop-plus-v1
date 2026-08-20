package com.coop_plus.api.Entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Pattern;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

@Entity
@Table(name = "employeers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "idUser")
public class EmployeeEntity extends UserEntity {
    @Pattern(regexp = "^[A-Za-zÀ-ÿ]+(?: [A-Za-zÀ-ÿ]+)*$", message = "O tipo de serviço só pode ser dito com palavras.")
    private String tipoServico;
    private String nomeEmpresa;
    @Pattern(regexp = "^[0-9]{2}[.][0-9]{3}[.][0-9]{3}[/][0-9]{4}[-][0-9]{2}")
    private String cnpj;
    private Integer avaliacoes;

    public EmployeeEntity(String nomeCompleto, String email, String senha, String descricao, String telefone, Integer avaliacoes,
                          UserRole role, String tipoServico,String nomeEmpresa, String cnpj){
        super(nomeCompleto, email, senha, descricao, telefone, role);
        this.tipoServico = tipoServico;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.avaliacoes = avaliacoes;
    }


}