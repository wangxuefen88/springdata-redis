package com.example.redisjudy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

@SpringBootApplication
public class RedisjudyApplicationTests {

	@Test
	public void contextLoads() {
	}
	public static void main(String[] args){
		SpringApplication.run(RedisjudyApplicationTests.class);
	}

}
