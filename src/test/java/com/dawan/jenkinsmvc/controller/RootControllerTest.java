package com.dawan.jenkinsmvc.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RootControllerTest {

    @Autowired
    RootController controller;

    @Test
    void shouldReturnIndex() {
        assertEquals(controller.index(), "index");
    }
}
