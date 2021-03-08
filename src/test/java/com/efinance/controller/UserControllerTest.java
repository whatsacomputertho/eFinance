/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efinance.controller;

import com.efinance.model.User;
import com.efinance.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest
{
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    
    @MockBean
    private UserService service;
    
    @Before
    public void setUp()
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
    /**
     * Test of toLogin method, of class UserController.
     */
    @Test
    public void testToLogin() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/login"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of loginUser method, of class UserController.
     */
    @Test
    public void testLoginUser() throws Exception
    {
        User user = new User();
        user.setEmail("email");
        user.setUserpass("pass");
        List<User> users = new ArrayList();
        users.add(user);
        when(service.getByEmail("email")).thenReturn(users);
        mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/validate"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of toHome method, of class UserController.
     */
    @Test
    public void testToHome() throws Exception
    {
        User user = new User();
        user.setFname("user");
        when(service.get(1)).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/home/user?id=1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
