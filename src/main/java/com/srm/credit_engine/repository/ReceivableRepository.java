package com.srm.credit_engine.repository;

import com.srm.credit_engine.entity.Receivable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivableRepository extends JpaRepository<Receivable, Long> {

}