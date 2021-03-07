package com.efinance.controller;

import com.efinance.model.User;
import com.efinance.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController
{
    @Autowired
    UserService userService;
    
    @RequestMapping("/login")
    public String toLogin(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }
    
    @RequestMapping(value="/validate", method=RequestMethod.POST)
    public String loginUser(@ModelAttribute("user") User user, Model model)
    {
        List<User> users = this.userService.getByEmail(user.getEmail());
        if(users.size() == 1)
        {
            if(user.getUserpass().equals(users.get(0).getUserpass()))
            {
                return "redirect:/home/user?id=" + users.get(0).getUserID();
            }
            else
            {
                model.addAttribute("feedback", "Incorrect username or password");
            }
        }
        else if(users.size() > 1)
        {
            model.addAttribute("feedback", String.format("Multiple users with email %s exist", user.getEmail()));
        }
        else
        {
            model.addAttribute("feedback", String.format("User with email %s does not exist", user.getEmail()));
        }
        return "login";
    }
    
    @RequestMapping("/home/user")
    public ModelAndView toHome(@RequestParam(name="id") Integer userid)
    {
        ModelAndView mav = new ModelAndView("home");
        User user = this.userService.get(userid);
        mav.addObject(user);
        return mav;
    }
}