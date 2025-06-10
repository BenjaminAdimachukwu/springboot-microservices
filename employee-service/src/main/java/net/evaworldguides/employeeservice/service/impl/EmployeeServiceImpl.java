package net.evaworldguides.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.evaworldguides.employeeservice.dto.APIResponseDto;
import net.evaworldguides.employeeservice.dto.DepartmentDto;
import net.evaworldguides.employeeservice.dto.EmployeeDto;
import net.evaworldguides.employeeservice.entity.Employee;
import net.evaworldguides.employeeservice.repository.EmployeeRepository;
import net.evaworldguides.employeeservice.service.APIClient;
import net.evaworldguides.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    //private RestTemplate restTemplate;
    private ModelMapper modelMapper;
   // private WebClient webClient;
    private APIClient apiClient;


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
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId) .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));;

//        ResponseEntity<DepartmentDto> responseEntity =
//                restTemplate.getForEntity("http://localhost:8080/api/departments/" +
//                        employee.getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

//                 DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/departments/" +
//                        employee.getDepartmentCode(), DepartmentDto.class)
//                .retrieve().bodyToMono(DepartmentDto.class).block();

        DepartmentDto departmentDto =  apiClient.getDepartment(employee.getDepartmentCode());


        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
//        EmployeeDto employeeDto = new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail()
//        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }
}
