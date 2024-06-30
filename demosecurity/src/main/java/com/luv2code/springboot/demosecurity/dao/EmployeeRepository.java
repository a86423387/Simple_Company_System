package com.luv2code.springboot.demosecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.demosecurity.entity.Employee;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findAllByOrderByLastNameAsc();

}
