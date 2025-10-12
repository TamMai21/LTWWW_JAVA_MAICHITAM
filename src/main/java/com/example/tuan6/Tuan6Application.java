package com.example.tuan6;

import com.example.tuan6.dao.EmployeeDAO;
import com.example.tuan6.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Tuan6Application {

    public static void main(String[] args) {
        SpringApplication.run(Tuan6Application.class, args);
    }
    @Bean
    CommandLineRunner runner(EmployeeDAO employeeDAO) {
        return args -> {
            Employee employee = Employee.builder().name("Nguyen Van A").role("ADMIN").build();
            employeeDAO.save(employee);

            List<Employee> employees = employeeDAO.getAll();
            employees.forEach(System.out::print);

            Employee employee2 = employeeDAO.getById(1);
            System.out.println(employee2);

            Employee employeeDirectMapper = employeeDAO.getByIdDirectMapper(1);
            System.out.println(employeeDirectMapper);
        };
    }
}
