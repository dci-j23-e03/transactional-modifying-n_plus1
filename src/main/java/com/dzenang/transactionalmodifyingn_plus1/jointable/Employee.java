package com.dzenang.transactionalmodifyingn_plus1.jointable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "employees", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer employeeId;

    @Column(nullable = false)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "employee_accounts", joinColumns = {@JoinColumn(name = "employee_id")},
    inverseJoinColumns = {@JoinColumn(name = "account_id")})
//    @ToString.Exclude
    private Set<Account> accounts = null;

}
