package com.example.tuan6.dao;

import com.example.tuan6.entity.Employee;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import com.example.tuan6.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EmployeeDAOImpl implements EmployeeDAO{
    EmployeeRepository employeeRepository;
    @Override
    public void updateEmployee(Employee e) {
        Employee isExitst = employeeRepository.findById(e.getId()).orElse(null);
        if(isExitst != null){
            employeeRepository.save(e);
        }
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void save(Employee e) {
        employeeRepository.save(e);
    }
    @Override
    public Employee getByIdDirectMapper(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

}
