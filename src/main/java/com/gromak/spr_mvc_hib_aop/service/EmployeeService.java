package com.gromak.spr_mvc_hib_aop.service;

import com.gromak.spr_mvc_hib_aop.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployeeById(int id);

    public void deleteEmployeeById(int id);
}
