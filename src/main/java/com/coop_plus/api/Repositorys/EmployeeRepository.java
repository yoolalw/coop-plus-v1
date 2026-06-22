package com.coop_plus.api.Repositorys;

import com.coop_plus.api.Entitys.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    Boolean existsByEmail(String email);
    Optional<EmployeeEntity> findByEmail(String email);
}
