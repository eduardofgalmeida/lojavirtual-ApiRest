package com.eduardo.lojavirtual.controllers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CostumerControllerTest {

	/*
	 * *
	 * Simple unit tests were created using jUnit
	 * *
	 */

	@Autowired
	public WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	// TESTING THE CODE SEARCH
	@Test
	public void TestRequestIdSuccess() throws Exception {
		String url = "api/costumer/findcod/1";
		this.mvc.perform(get(url)).andExpect(status().isOk());
	}

	//FAILURE TEST WHEN PERFORMING THE CODE SEARCH
	@Test
	public void TestRequestIdFailed() throws Exception {
		String url = "api/costumer/findcod/99999999";
		this.mvc.perform(get(url)).andExpect(status().isNotFound());
	}
	
	//NAME SEARCH TEST
	@Test
	public void TestRequestFindNameSuccess() throws Exception {
		String url = "api/costumer/like/findname/teste";
		this.mvc.perform(get(url))
		.andExpect(status().isOk());
	}
	
	//SUCCESSFUL DELECTION TEST
	@Test
	public void TestRequestDeleteSuccessful() throws Exception {
		String url = "api/costumer/delete/1";
		this.mvc.perform(delete(url))
		.andExpect(status().isOk())
		.andExpect((ResultMatcher) content().string(containsString("1")));
	}
	
	//TEST FAILURE TEST
	@Test
	public void TestRequestDeleteFailed() throws Exception {
		String url = "api/costumer/delete/1";
		this.mvc.perform(delete(url))
		.andExpect(status().isNotFound());
	}
	
	
	
	


}
