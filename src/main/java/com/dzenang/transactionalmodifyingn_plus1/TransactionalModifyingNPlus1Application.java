package com.dzenang.transactionalmodifyingn_plus1;

import com.dzenang.transactionalmodifyingn_plus1.jointable.Account;
import com.dzenang.transactionalmodifyingn_plus1.jointable.Employee;
import com.dzenang.transactionalmodifyingn_plus1.jointable.EmployeeRepository;
import com.dzenang.transactionalmodifyingn_plus1.jointable.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class TransactionalModifyingNPlus1Application {

    public static void main(String[] args) {
        SpringApplication.run(TransactionalModifyingNPlus1Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Employees stored in db:");

            EmployeeRepository employeeRepository = ctx.getBean(EmployeeRepository.class);
            EmployeeService employeeService = ctx.getBean(EmployeeService.class);

            employeeService.printEmployees();
//            Set<Account> firstEmployeeAccounts = employees.getFirst().getAccounts();
//            System.out.println("Accounts of first employee: " + firstEmployeeAccounts);
//            System.out.println("Deleting the employee with name emp1firstname: " + employeeService.deleteEmployee("emp2firstname"));

//            System.out.println("Updating employees with gmail email...");
//            employeeRepository.updateEmployeesWithGmail();
//            employees = employeeRepository.findAll();
//            employees.forEach(System.out::println);
        };
    }
}
