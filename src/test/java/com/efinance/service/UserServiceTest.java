/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efinance.service;
import com.efinance.model.User;
import com.efinance.repository.UserRepository;
import com.efinance.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.then;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserServiceTest {
    @MockBean
    @Mock
    private UserRepository userRepository;
    
    @InjectMocks
    private UserService service;
    
    @Test
    public void listAllTest(){
        List<User> users = new ArrayList<User>();
        User first = new User ();
        first.setUserID(1);
        first.setEmail("email");
        first.setFname("Fname");
        first.setLname("Lname");
        first.setUserpass("pass");
        first.setUserType(User.UserType.LOANCONSULTANT);
        User second = new User ();
        second.setUserID(2);
        second.setEmail("email2");
        second.setFname("Fname2");
        second.setLname("Lname2");
        second.setUserpass("pass2");
        second.setUserType(User.UserType.LOANOFFICER);
        User third = new User ();
        third.setUserID(3);
        third.setEmail("email3");
        third.setFname("Fname3");
        third.setLname("Lname3");
        third.setUserpass("pass3");
        third.setUserType(User.UserType.CUSTOMER);
        users.add(first);
        users.add(second);
        users.add(third);
        
        when(userRepository.findAll()).thenReturn(users);
        assertEquals(this.service.listAll(),users);
    }
    
    @Test
    public void getTest(){
        User user = new User();
        user.setUserID(1);
        user.setEmail("email");
        user.setFname("Fname");
        user.setLname("Lname");
        user.setUserpass("pass");
        user.setUserType(User.UserType.LOANCONSULTANT);
        
        Optional<User> userOptional = Optional.of(user);
       when(userRepository.findById(1)).thenReturn(userOptional);
       assertEquals(this.service.get(1),user);
    }
    
    @Test
    public void getByEmailTest(){
        List<User> users = new ArrayList<User>();
        User first = new User ();
        first.setUserID(1);
        first.setEmail("email");
        first.setFname("Fname");
        first.setLname("Lname");
        first.setUserpass("pass");
        first.setUserType(User.UserType.LOANCONSULTANT);
        
        
        users.add(first);
        
        when(userRepository.findByEmail("email")).thenReturn(users);
        assertEquals(this.service.getByEmail("email"),users);
        
    }
}