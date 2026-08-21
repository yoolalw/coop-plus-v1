package com.coop_plus.api.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @Pattern(
            regexp = "^[A-Za-zÀ-ÿ]+(?: [A-Za-zÀ-ÿ]+)*$",
            message = "O nome deve conter apenas letras."
    )
    private String nomeCompleto;

    private String email;
    private String senha;
    private String descricao;

    @Pattern(regexp = "^[0-9]{2}\s[9]{1}\s[0-9]{4}[-][0-9]{4}$")
    private String telefone;

    private String foto_perfil;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public UserEntity(String nomeCompleto, String email, String senha, String descricao, String telefone, String foto_perfil,UserRole role) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.descricao = descricao;
        this.telefone = telefone;
        this.foto_perfil = foto_perfil;
        this.role = role;
    }


    public Object getRole(UserRole userRole) {
        return userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+ role.name()));
    }

    @Override
    public @Nullable String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
