package com.eduardo.lojavirtual.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardo.lojavirtual.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Order> findByCod(BigDecimal cod) throws Exception;
	
	

}
