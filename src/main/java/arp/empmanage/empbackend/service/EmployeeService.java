package arp.empmanage.empbackend.service;

import java.util.List;

import arp.empmanage.empbackend.dto.EmployeeDto;

public interface EmployeeService {
     EmployeeDto createEmployee(EmployeeDto employeeDto);

     EmployeeDto getEmployeeById(Long employeeId);

     List<EmployeeDto> getAllEmployees();

     EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

     void deleteEmployee(Long EmployeeId);
}
