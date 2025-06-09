package net.evawolrdguides.department_service.repository;

import net.evawolrdguides.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentCode(String departmentCode);
}
