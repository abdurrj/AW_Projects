package com.example.checkpoint_9;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class Checkpoint9ApplicationTests {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void contextLoads() {
    }

    @Test
    @WithMockUser(username = "user", password = "123")
    public void shouldFindExchangeRate() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/convert?amount=100&currency=USD")
        ).andExpect(status().is2xxSuccessful());

    }
}
