package com.dawan.jenkinsmvc;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WebSecurityConfigTest {

    @Autowired
    WebSecurityConfig webSecurityConfig;

    @Test
    void securityFilterChain() {
        assertDoesNotThrow(() -> webSecurityConfig.securityFilterChain(ArgumentMatchers.any()));
    }
}
