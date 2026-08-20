package com.coop_plus.api.Repositorys;

import com.coop_plus.api.Entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByEmail(String email);
}
