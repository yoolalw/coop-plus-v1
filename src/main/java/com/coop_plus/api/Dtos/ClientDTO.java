package com.coop_plus.api.Dtos;

import com.coop_plus.api.Entitys.UserRole;

public record ClientDTO(String email, String senha, UserRole role) {
}
