package net.evaworldguides.employeeservice.service;

import net.evaworldguides.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("/api/departments/{departmentCode}")
    DepartmentDto getDepartment(@PathVariable("departmentCode") String departmentCode);
}

