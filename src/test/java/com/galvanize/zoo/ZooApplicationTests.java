package com.galvanize.zoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

	String setup() throws Exception{
		Animal animal = new Animal("Deer","walking");
		mockmvc.perform(post("/zoo/animals")
				.content(mapper.writeValueAsString(animal))
				.contentType(MediaType.APPLICATION_JSON)
		).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").value("Deer"));
		return animal.getId();
	}

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

	@Test
	void getAllAnimalsTest() throws Exception{
		String id = this.setup();
		mockmvc.perform(get("/zoo/animals"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(1))
				.andExpect(jsonPath("$.[0].id").value(id));
	}

	@Test
	void feedAnimalsTest() throws Exception{
		String id = this.setup();

		//Acceptance Criteria - 3a.
		//Given an animal is unhappy When I give it a treat Then the animal is happy
		mockmvc.perform(put("/zoo/animals")
						.contentType(MediaType.APPLICATION_JSON)
						.content(id))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(id))
				.andExpect(jsonPath("$.mood").value("Happy"));
		//Acceptance Criteria - 3a.
		//Given an animal is unhappy When I give it a treat Then the animal is happy
		mockmvc.perform(put("/zoo/animals")
				.contentType(MediaType.APPLICATION_JSON)
				.content(id))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(id))
				.andExpect(jsonPath("$.mood").value("Happy"));

	}

	@Test
	void allocateAnimalsTest() throws Exception{
		String id = this.setup();

		mockmvc.perform(post("/zoo/allocateanimals")
						.contentType(MediaType.APPLICATION_JSON)
						.content(id))
				.andExpect(status().isOk());
				//.andExpect(jsonPath("$").exists());
	}

}
