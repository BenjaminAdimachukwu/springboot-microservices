package net.evaworldguides.employeeservice.service;

import net.evaworldguides.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto  saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
}
