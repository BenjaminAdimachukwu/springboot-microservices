package net.evaworldguides.employeeservice.service;

import net.evaworldguides.employeeservice.dto.APIResponseDto;
import net.evaworldguides.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto  saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
