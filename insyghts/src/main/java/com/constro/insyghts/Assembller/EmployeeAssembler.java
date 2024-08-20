package com.constro.insyghts.Assembller;

import com.constro.insyghts.Dto.EmployeeDto;
import com.constro.insyghts.Entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeAssembler {
    public EmployeeDto toDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setPosition(employee.getPosition());
        employeeDto.setSalary(employee.getSalary());
        return employeeDto;
    }

    public Employee toEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setPosition(employeeDto.getPosition());
        employee.setSalary(employeeDto.getSalary());
        return employee;
    }
}
