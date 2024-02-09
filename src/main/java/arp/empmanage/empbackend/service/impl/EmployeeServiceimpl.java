package arp.empmanage.empbackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arp.empmanage.empbackend.dto.EmployeeDto;
import arp.empmanage.empbackend.entity.Employee;
import arp.empmanage.empbackend.exception.ResourceNotFoundException;
import arp.empmanage.empbackend.mapper.EmployeeMapper;
import arp.empmanage.empbackend.repository.EmployeeRepository;
import arp.empmanage.empbackend.service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

         Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
         Employee savedEmployee = employeeRepository.save(employee);

         return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       
        Employee employee = employeeRepository.findById(employeeId)
           .orElseThrow(()->
             new ResourceNotFoundException("Employee is not found with the id : " + employeeId)
           );

           return EmployeeMapper.mapToEmployeeDto(employee);
       
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return  employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee))
        .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
           .orElseThrow(()->
             new ResourceNotFoundException("Employee is not found with the id : " + employeeId)
           );

           employee.setFirstname(updatedEmployee.getFirstname());
           employee.setLastname(updatedEmployee.getLastname());
           employee.setEmail(updatedEmployee.getEmail());

           Employee updatedEmployeeObj = employeeRepository.save(employee);

       return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
        .orElseThrow(()->
          new ResourceNotFoundException("Employee is not found with the id : " + employeeId)
        );
      
        employeeRepository.deleteById(employeeId);
        
    }
    
}
