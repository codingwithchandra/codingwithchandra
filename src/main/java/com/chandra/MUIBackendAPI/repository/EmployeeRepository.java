package com.chandra.MUIBackendAPI.repository;

import com.chandra.MUIBackendAPI.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
