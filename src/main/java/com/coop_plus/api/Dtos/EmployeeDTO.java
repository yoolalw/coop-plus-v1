package com.coop_plus.api.Dtos;

import com.coop_plus.api.Entitys.UserRole;

public record EmployeeDTO(String nomeCompleto, String email, String senha, String descricao, String telefone, Integer avaliacoes,
                          UserRole role, String tipoServico,String nomeEmpresa, String cnpj, String foto_perfil) {
}
