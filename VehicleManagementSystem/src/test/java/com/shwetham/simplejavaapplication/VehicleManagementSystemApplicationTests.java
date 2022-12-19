package com.shwetham.simplejavaapplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.shwetham.simplejavaapplication.controller.VehicleController;
import com.shwetham.simplejavaapplication.dto.VehicleDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class VehicleManagementSystemApplicationTests {

	@Autowired
	private VehicleController vehicleController;

	@LocalServerPort
	private int randomServerPort;

	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private MockMvc mockmvc;

	@Before
	public void setUp() {
		mockmvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void addVehicleTest() throws Exception {
		System.out.println("post test: randomServerPort: " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/VehicleSystem/create";
		URI uri = new URI(baseUrl);
		VehicleDTO dto = new VehicleDTO("1278365243", "2 wheeler", "Pept", "yamaha", 85000.00);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(dto);
		System.out.println("post requestJson: " + requestJson);
		mockmvc.perform(post(uri).contentType("application/json").accept("*/*").content(requestJson))
				.andExpect(status().isOk());
	}

	@Test
	public void getVehicleTest() throws Exception {
		final String baseUrl = "http://localhost:" + randomServerPort + "/VehicleSystem/get";
		URI uri = new URI(baseUrl);
		mockmvc.perform(get(uri).contentType("application/json").accept("*/*")).andExpect(status().isOk());
	}

	@Test
	public void deleteVehicleTest() throws Exception {
		final String baseUrl = "http://localhost:" + randomServerPort + "/VehicleSystem/delete?id=6";
		URI uri = new URI(baseUrl);
		mockmvc.perform(delete(uri).contentType("application/json").accept("*/*")).andExpect(status().isOk());
	}

	@Test
	public void updateVehicleTest() throws Exception {
		final String baseUrl = "http://localhost:" + randomServerPort + "/VehicleSystem/update";
		URI uri = new URI(baseUrl);
		VehicleDTO dto = new VehicleDTO(8L, "1278365243", "2 wheeler", "scooty", "yamaha", 60000.00);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(dto);
		mockmvc.perform(put(uri).contentType("application/json").accept("*/*").content(requestJson))
				.andExpect(status().isOk());
	}

}
