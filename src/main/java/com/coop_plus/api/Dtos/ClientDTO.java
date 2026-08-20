package com.coop_plus.api.Dtos;

import com.coop_plus.api.Entitys.UserRole;

public record ClientDTO(String nomeCompleto, String email, String senha,
                        String descricao, String telefone, UserRole role, String cpf, String endereco,
                        Integer avaliacoes, String foto_perfil) {
}