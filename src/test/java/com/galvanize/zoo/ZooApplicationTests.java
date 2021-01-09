package com.galvanize.zoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
class ZooApplicationTests {

	@Autowired
	private MockMvc mockmvc;

	@Autowired
	private ObjectMapper mapper;

	//Add animal(Post request) :   /zoo/animals — Adding animal to zoo and post use
	//- 201 created

	@Test
	void addAnimalsTest() throws Exception {
		Animal animal = new Animal("Deer","walking");
		mockmvc.perform(post("/zoo/animals")
						.content(mapper.writeValueAsString(animal))
						.contentType(MediaType.APPLICATION_JSON)
						).andDo(MockMvcResultHandlers.print())
						.andExpect(status().isCreated())
						.andExpect(jsonPath("$.id").exists())
						.andExpect(jsonPath("$.name").value("Deer"));

	}


}
