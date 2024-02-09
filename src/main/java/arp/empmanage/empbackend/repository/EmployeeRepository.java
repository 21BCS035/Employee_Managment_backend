package arp.empmanage.empbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import arp.empmanage.empbackend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    
}
