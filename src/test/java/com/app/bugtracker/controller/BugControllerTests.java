package com.app.bugtracker.controller;

import com.app.bugtracker.model.Bug;
import com.app.bugtracker.model.State;
import com.app.bugtracker.model.Type;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BugControllerTests {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void indexTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/bug/{id}", "1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        assert Objects.equals(mvcResult.getResponse().getStatus(), HttpStatus.OK.value());
    }

    @Test
    public void saveTest() throws Exception {
        Bug bug = new Bug(1, "Test Bug", "Test Bug Description", Type.Task, State.New, "User");
        String request = objectMapper.writeValueAsString(bug);
        MvcResult mvcResult = mockMvc.perform(post("/bug").content(request).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        assert Objects.equals(mvcResult.getResponse().getStatus(), HttpStatus.OK.value());
    }

    @Test
    public void updateTest() throws Exception {
        Bug bug = new Bug(1, "Test Bug", "Test Bug Description", Type.Task, State.New, "User");
        String request = objectMapper.writeValueAsString(bug);
        MvcResult mvcResult = mockMvc.perform(put("/bug").content(request).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        assert Objects.equals(mvcResult.getResponse().getStatus(), HttpStatus.OK.value());
    }

    @Test
    public void deleteTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(delete("/bug/{id}", "1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        assert Objects.equals(mvcResult.getResponse().getStatus(), HttpStatus.OK.value());
    }
}
