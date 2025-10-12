package com.example.tuan6.dao;

import com.example.tuan6.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void updateEmployee(Employee e);
    List<Employee> getAll();
    Employee getById(int id);
    void deleteById(int id);
    void save(Employee e);
    Employee getByIdDirectMapper(int id);
}
