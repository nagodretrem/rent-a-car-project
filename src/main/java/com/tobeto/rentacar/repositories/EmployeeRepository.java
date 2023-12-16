package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
