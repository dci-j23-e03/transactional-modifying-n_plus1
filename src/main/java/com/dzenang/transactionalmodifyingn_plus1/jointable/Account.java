package com.dzenang.transactionalmodifyingn_plus1.jointable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer accountId;

    @Column(name = "acc_number", nullable = false, unique = true)
    private String accountNumber;

}
