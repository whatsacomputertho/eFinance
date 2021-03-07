package com.efinance.service;

import com.efinance.model.User;
import com.efinance.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;
    
    public List<User> listAll()
    {
        return this.userRepository.findAll();
    }
    
    public void save(User user)
    {
        this.userRepository.save(user);
    }
    
    public User get(Integer id)
    {
        return this.userRepository.findById(id).get();
    }
    
    public List<User> getByEmail(String email)
    {
        return this.userRepository.findByEmail(email);
    }
    
    public void delete(Integer id)
    {
        this.userRepository.deleteById(id);
    }
}
