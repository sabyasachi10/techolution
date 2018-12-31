package com.tech.maxSatis.restController;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class MaxSatisRestControllerTest {

	private MaxSatisRestController maxSatisRestController;
	
	@Before
    public void setUp() {
		maxSatisRestController = new MaxSatisRestController();
	}
	
	@Test
	public void getMaxSatisfactionTest () throws IOException {
		ResponseEntity<String> response = maxSatisRestController.getMaxSatisfaction("15");
		assertEquals("Maximum satisfaction on the given time 15 is : 80.0", response.getBody());
	}
}
