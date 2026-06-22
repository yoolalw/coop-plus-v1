package com.coop_plus.api.Repositorys;

import com.coop_plus.api.Entitys.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
