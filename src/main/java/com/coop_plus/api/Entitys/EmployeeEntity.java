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

@Entity
@Table(name = "employeers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity implements UserDetails {
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
    private String email;
    private String senha;
    private String nomeEmpresa;

    private Boolean favorito;
    private String descricao;

    @Pattern(regexp = "^[0-9]{2}[.][0-9]{3}[.][0-9]{3}[/][0-9]{4}[-][0-9]{2}")
    private String cnpj;

    @Pattern(regexp = "^[0-9]{2}\s[9]{1}\s[0-9]{4}[-][0-9]{4}$")
    private String telefone;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}