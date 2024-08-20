package com.constro.insyghts.Repository;

import com.constro.insyghts.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Set<Employee> findByConstructionSiteId(Long constructionSiteId);
}
