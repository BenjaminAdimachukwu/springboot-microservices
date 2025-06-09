package net.evaworldguides.employeeservice.controller;

import lombok.AllArgsConstructor;
import net.evaworldguides.employeeservice.dto.EmployeeDto;
import net.evaworldguides.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")

public class EmployeeController {
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee (@RequestBody EmployeeDto employeeDto){
      EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    };

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
}
