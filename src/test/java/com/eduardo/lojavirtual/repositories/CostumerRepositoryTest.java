package com.eduardo.lojavirtual.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.eduardo.lojavirtual.models.Costumer;
import com.eduardo.lojavirtual.repository.CostumerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CostumerRepositoryTest {
	
	/*
	 * *
	 * Simple unit tests were created using jUnit
	 * *
	 */
	
	@Autowired
	private CostumerRepository costumerRepository;
	
	//TEST TO SEE IF THE REPOSITORY IS WORKING
	@Test
	public void testCostumerSearch() throws Exception {
		List<Costumer> costumer = costumerRepository.findCostumerByNameIgnoreCase("teste");
		assertThat(costumer.size()).isEqualTo(1);
	}
	
	//TEST TO SEE IF THE REPOSITORY IS BRINGING INFORMATION
	@Test
	public void testCostumer() throws Exception {
		List<Costumer> costumer = costumerRepository.findAll();
		assertThat(costumer.size()).isNotZero();
	}
	
}
