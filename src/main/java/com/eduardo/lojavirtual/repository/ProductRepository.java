package com.eduardo.lojavirtual.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eduardo.lojavirtual.models.Costumer;
import com.eduardo.lojavirtual.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByCod(BigDecimal cod) throws Exception;
	
	@Query("select c from Product c where c.name like %?1%")
	List<Product> findProductByName(String Name) throws Exception;

}
