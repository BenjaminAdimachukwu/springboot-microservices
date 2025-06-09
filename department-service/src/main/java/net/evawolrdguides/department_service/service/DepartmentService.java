package net.evawolrdguides.department_service.service;

import net.evawolrdguides.department_service.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment( DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode (String code);
}
