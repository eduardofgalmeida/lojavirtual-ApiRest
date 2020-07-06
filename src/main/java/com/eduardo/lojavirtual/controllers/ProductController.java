package com.eduardo.lojavirtual.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.lojavirtual.models.Costumer;
import com.eduardo.lojavirtual.models.Product;
import com.eduardo.lojavirtual.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/product")
@Api(value = "API REST Product")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@ResponseBody
	@GetMapping("/all")
	@ApiOperation(value = "Returns all products")
	public List<Product> productAll() throws Exception {

		List<Product> ltResult = null;
		try {
			ltResult = productRepository.findAll();
		} catch (Exception e) {
			log.error("productAll: {}", e.toString());
		}
		return ltResult;
	}

	@ResponseBody
	@GetMapping("/cod/{cod}")
	@ApiOperation(value = "Returning product by code")
	public List<Product> productFindCod(@PathVariable("cod") BigDecimal cod) throws Exception {

		log.info("Returning product by code");
		List<Product> ltResult = null;
		try {
			ltResult = productRepository.findByCod(cod);
		} catch (Exception e) {
			log.error("productCod: {}", e.toString());
		}
		return ltResult;
	}

	@ResponseBody
	@GetMapping("/findname")
	@ApiOperation(value = "Returning product by name")
	public List<Product> productFindName(@RequestBody Costumer product, String name) throws Exception {

		log.info("Returning product by name");
		List<Product> ltResult = null;
		try {
			ltResult = productRepository.findProductByName(name);
		} catch (Exception e) {
			log.error("costumerAll: {}", e.toString());
		}
		return ltResult;
	}

	@ApiOperation(value = "Register Product")
	@PostMapping("/register")
	public Product registerProduct(@RequestBody Product product) {

		Product result = new Product();
		log.info("Registering the product");
		try {
			result = productRepository.save(product);
		} catch (Exception e) {
			log.error("registerProduct: {}", e.toString());
		}
		return result;
	}

	@ApiOperation(value = "Delete Products")
	@DeleteMapping("delete/id/{id}")
	public void deleteProduct(@RequestBody Product product, Long id) {

		log.info("Deleting product");
		try {
			productRepository.deleteById(id);
		} catch (Exception e) {
			log.error("deleteProduct: {}", e.toString());
		}
	}

	@ApiOperation(value = "Updates Product")
	@PutMapping("/update")
	public Product updatesProduct(@RequestBody Product product) {
		Product result = new Product();

		log.info("Updating Product");
		try {
			result = productRepository.save(product);
		} catch (Exception e) {
			log.error("updatesProduct: {}", e.toString());
		}
		return result;
	}

}
