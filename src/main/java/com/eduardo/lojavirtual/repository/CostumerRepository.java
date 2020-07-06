package com.eduardo.lojavirtual.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eduardo.lojavirtual.models.Costumer;


@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long> {

	@Query("select c from Costumer c where c.name like %?1%")
	List<Costumer> findCostumerByNameIgnoreCase(String Name) throws Exception;
	
	List<Costumer> findCostumerByCod(BigDecimal cod) throws Exception;
	
}
