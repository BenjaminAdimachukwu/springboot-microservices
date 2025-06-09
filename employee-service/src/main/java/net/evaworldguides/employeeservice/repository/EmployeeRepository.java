package net.evaworldguides.employeeservice.repository;

import net.evaworldguides.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
