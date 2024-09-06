package com.dzenang.transactionalmodifyingn_plus1.jointable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public boolean saveEmployees(List<Employee> employees) {
        employeeRepository.save(employees.get(0));
        employeeRepository.save(employees.get(1));
        return true;
    }

    public boolean deleteEmployee(String name) {
        return employeeRepository.deleteEmployeeByFirstName(name) == 1;
    }

    public void printEmployees() {
        List<Employee> employees = employeeRepository.findAllEmployees();
        employees.forEach(System.out::println);
    }
}
