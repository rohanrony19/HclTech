package com.springboot.transactional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.transactional.model.Account;

import jakarta.persistence.LockModeType;
@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select a from Account a where a.id =:id")
	Account findByIdUpdate(@Param("id") Long id);
}
