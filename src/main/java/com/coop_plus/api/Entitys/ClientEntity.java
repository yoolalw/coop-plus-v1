package com.coop_plus.api.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity implements UserDetails {
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
    private String senha;

    @Pattern(regexp = "^[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][0-9]{2}$", message = "CPF não encontrado.")
    private String cpf;

    @Pattern(regexp = "^[0-9]{2}\s[9]{1}\s[0-9]{4}[-][0-9]{4}$")
    private String telefone;

    private UserRole role;

    public ClientEntity(String nomeCompleto, String endereco, String email, String senha, String cpf, String telefone, UserRole role){
        this.nomeCompleto = nomeCompleto;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
        this.role = role;
    }
/*
{
    "nomeCompleto": "Abcd",
    "endereco":"A 1, V2",
    "email":"a@email.com",
    "senha":"aaa",
    "cpf":"000.000.000.01",
    "telefone": "01 9 0000-1111",
    "role": "USER"
}
 */
    /*
    "nomeCompleto": "",
    "endereco":"",
    "email":"",
    "senha":"",
    "cpf":"000.000.000.01",
    "telefone": "01 9 0000-1111",
    "role": "client"
     */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return senha;
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

    public Object getRole(UserRole userRole) {
        return userRole;
    }
}
