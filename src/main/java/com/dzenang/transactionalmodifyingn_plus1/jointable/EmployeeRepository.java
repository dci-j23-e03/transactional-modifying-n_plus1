package com.dzenang.transactionalmodifyingn_plus1.jointable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // @Transactional can be used here, or at Service layer, Service is recommended
    @Transactional
    Optional<Employee> findEmployeeByFirstNameAndLastName(String firstName, String lastName);

    @Modifying
    @Query("delete Employee e where e.firstName = :name")
    int deleteEmployeeByFirstNameCustom(String name);

    int deleteEmployeeByFirstName(String firstName);

    @Modifying
    @Transactional
    @Query("update Employee e set e.email = 'dummy' where e.email like '%@gmail.com'")
    void updateEmployeesWithGmail();

    @Query("select e from Employee e join fetch e.accounts")
    List<Employee> findAllEmployees();

//    @Query(nativeQuery = true,
//            value = "select e.id, e.email, e.first_name, e.last_name from employees e " +
//                    "join employee_accounts ea on e.id = ea.employee_id " +
//                    "join accounts a on a.id = ea.account_id")
//    List<Employee> findAllEmployeesWithNativeQuery();

}
