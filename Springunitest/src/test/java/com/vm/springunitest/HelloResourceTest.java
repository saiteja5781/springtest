package com.vm.springunitest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class HelloResourceTest {

	MockMvc mockMvc;

	@InjectMocks
	HelloResource helloResource;

	
	  @Test 
	  public void testSayHello() throws Exception
	  { 
		  mockMvc =
	  MockMvcBuilders.standaloneSetup(helloResource).build();
	  
	  mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
	  .andExpect(MockMvcResultMatchers.status().isOk())
	  .andExpect(MockMvcResultMatchers.content().string("hello abdul"));
	  
	  }
	 

	@Test
	public void testStudentJson() throws Exception {

		mockMvc = MockMvcBuilders.standaloneSetup(helloResource).build();
		mockMvc.perform(get("/student").accept(MediaType.APPLICATION_JSON))

				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.name", Matchers.is("abdul")))
				.andExpect(jsonPath("$.name", Matchers.is("abdul")));
	}
}