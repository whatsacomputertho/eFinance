/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efinance.repository;

import com.efinance.model.User;
import java.util.List;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest
{
    @Autowired
    public UserRepository repository;
    
    @Autowired
    public TestEntityManager entityManager;
    
    @Test
    public void testFindAllUsers()
    {
        List<User> users = repository.findAll();
        assert(users.size() > 0);
    }
    
    @Test
    public void testSaveUser()
    {
        User newUser = new User();
        newUser.setEmail("user10@email.com");
        newUser.setUserpass("pass10");
        User user = repository.save(newUser);
        assertNotNull(user);
        assertTrue(user.getUserID() > 0);
        assert(user.getEmail().equals(newUser.getEmail()));
        assert(user.getUserpass().equals(newUser.getUserpass()));
    }
    
    @Test
    public void testFindUserById()
    {
        User user = repository.findById(1).orElseGet(null);
        assertNotNull(user);
        assert(user.getUserID() == 1);
    }
    
    @Test
    public void testFindUserByEmail()
    {
        List<User> users = repository.findByEmail("user1@email.com");
        assert(users.size() <= 1);
    }
}