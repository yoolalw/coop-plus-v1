package com.coop_plus.api.Repositorys;

import com.coop_plus.api.Entitys.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
}
