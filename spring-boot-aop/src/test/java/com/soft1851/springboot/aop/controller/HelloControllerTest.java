package com.soft1851.springboot.aop.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@WebAppConfiguration
@Slf4j
class HelloControllerTest {
    //用户模拟调用Controller的接口发起请求
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;


    @BeforeEach
    public void setUp() throws Exception{
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    void getHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/hello")
                .header("token","12345")
                .param("arg1","soft1851")
                .param("arg2","11"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello spring boot aop"))
                .andDo(MockMvcResultHandlers.print());
    }
}