package com.coop_plus.api.Repositorys;

import com.coop_plus.api.Entitys.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
    boolean existsByEmail(String email);
    ClientEntity findByEmail(String email);
}
