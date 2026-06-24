package com.coop_plus.api.Dtos;

import com.coop_plus.api.Entitys.UserRole;

public record ClientDTO(String nomeCompleto, String endereco, String email, String senha, String cpf, String telefone, UserRole role) {
}
