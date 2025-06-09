package net.evaworldguides.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.evaworldguides.employeeservice.dto.EmployeeDto;
import net.evaworldguides.employeeservice.entity.Employee;
import net.evaworldguides.employeeservice.repository.EmployeeRepository;
import net.evaworldguides.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = modelMapper.map(employeeDto, Employee.class);
//        Employee employee = new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail()
//        );
       Employee savedEmployee = employeeRepository.save(employee);

       EmployeeDto employeeDto1 = modelMapper.map(savedEmployee, EmployeeDto.class);

//        EmployeeDto employeeDto1 = new EmployeeDto(
//                savedEmployee.getId(),
//                savedEmployee.getFirstName(),
//                savedEmployee.getLastName(),
//                savedEmployee.getEmail()
//        );
        return employeeDto1;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
//        EmployeeDto employeeDto = new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail()
//        );
        return employeeDto;
    }
}
