package net.evawolrdguides.department_service.service.impl;

import lombok.AllArgsConstructor;
import net.evawolrdguides.department_service.dto.DepartmentDto;
import net.evawolrdguides.department_service.entity.Department;
import net.evawolrdguides.department_service.repository.DepartmentRepository;
import net.evawolrdguides.department_service.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

//    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
//        this.departmentRepository = departmentRepository;
//    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert departmentDTO to departmentEntity
Department department = modelMapper.map(departmentDto, Department.class);
//        Department department = new Department(
//                departmentDto.getId(),
//                departmentDto.getDepartmentName(),
//                departmentDto.getDepartmentDescription(),
//                departmentDto.getDepartmentCode()
//        );
      Department  savedDepartment =  departmentRepository.save(department);
      DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);
//      DepartmentDto savedDepartmentDto = new DepartmentDto(
//              savedDepartment.getId(),
//              savedDepartment.getDepartmentName(),
//              savedDepartment.getDepartmentDescription(),
//              savedDepartment.getDepartmentCode()
//      );
      return  savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
//        DepartmentDto departmentDto = new DepartmentDto(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//        );
        return departmentDto;
    }
}
