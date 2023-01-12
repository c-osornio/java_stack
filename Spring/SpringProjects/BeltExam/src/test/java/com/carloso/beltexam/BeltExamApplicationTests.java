package com.carloso.beltexam;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.carloso.beltexam.controllers.UserController;

@SpringBootTest
class BeltExamApplicationTests {

    @Autowired
    private UserController controller;
    
	@Test
	void contextLoads() {
	}

    @Test
    void testController() {
        assertThat(controller).isNotNull();
    }
}
