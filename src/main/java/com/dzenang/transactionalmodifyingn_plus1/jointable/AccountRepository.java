package com.dzenang.transactionalmodifyingn_plus1.jointable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
