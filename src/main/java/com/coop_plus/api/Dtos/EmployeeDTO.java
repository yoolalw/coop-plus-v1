package com.coop_plus.api.Dtos;

import com.coop_plus.api.Entitys.UserRole;

public record EmployeeDTO(String nomeCompleto, String tipoServico, String email, String senha,
                          String nomeEmpresa, String descricao, String cnpj,
                          String telefone, UserRole role) {
}
