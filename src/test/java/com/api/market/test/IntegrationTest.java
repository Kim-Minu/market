package com.api.market.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.annotation.Profile;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@Profile("local")
@Transactional
@Disabled
public class IntegrationTest {
    @Autowired
    protected MockMvc mvc;
    @Autowired protected ObjectMapper objectMapper;
}
