package net.evawolrdguides.department_service.controller;

import lombok.AllArgsConstructor;
import net.evawolrdguides.department_service.dto.DepartmentDto;
import net.evawolrdguides.department_service.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

//    public DepartmentController(DepartmentService departmentService) {
//        this.departmentService = departmentService;
//    }

    // build save department rest api
    @PostMapping
    public ResponseEntity<DepartmentDto> savedDepartment( @RequestBody DepartmentDto departmentDto){
       DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
       return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    // build get department rest API
    @GetMapping("{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("departmentCode") String departmentCode){
       DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
         return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
