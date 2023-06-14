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

    @Mock
    HttpSecurity http;
    @Test
    void securityFilterChain() throws Exception {
        Mockito.when(http.authorizeHttpRequests(ArgumentMatchers.any())).thenReturn(http);
        Mockito.when(http.logout(ArgumentMatchers.any())).thenReturn(http);
        Mockito.when(http.build()).thenReturn(null);
        assertDoesNotThrow(() -> webSecurityConfig.securityFilterChain(http));
    }
}
