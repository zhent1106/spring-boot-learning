package com.soft1851.springboot.verification.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soft1851.springboot.verification.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {
@Autowired
private MockMvc mockMvc;
@Autowired
private ObjectMapper objectMapper;
    @Test
    public  void getPerson() throws Exception {
        Person person=new Person();
        person.setId("1802343315");
        person.setName("zhent");
        person.setAge(20);
        person.setPhone("15035897885");
        person.setEmail("zhent1106@163.com");
        person.setSex("Man");

        MockHttpServletRequestBuilder requestBuilder=
                MockMvcRequestBuilders.post("/api/person").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(person));
        mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getPersonById() throws  Exception{
        MockHttpServletRequestBuilder requestBuilder=
                MockMvcRequestBuilders.get("/api/person/1122").contentType(MediaType.TEXT_PLAIN);
        mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.content().string("getPersonById.id:id不能小于6位")).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getPersonByName()  throws Exception{
        MockHttpServletRequestBuilder requestBuilder=
                MockMvcRequestBuilders.get("/api/person").contentType(MediaType.APPLICATION_JSON).param("name",
                        "zhent1106061616");
        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string("getPersonByName.name:name长度超出范围"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }
}