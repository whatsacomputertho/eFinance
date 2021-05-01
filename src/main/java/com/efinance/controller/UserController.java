package com.efinance.controller;

import com.efinance.model.Loan;
import com.efinance.model.PaymentAccount;
import com.efinance.model.User;
import com.efinance.service.LoanService;
import com.efinance.service.PaymentAccountService;
import com.efinance.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.ui.ModelMap;

@Controller
public class UserController
{
    @Autowired
    UserService userService;
    
    @Autowired
    LoanService loanService;
    
    @Autowired
    PaymentAccountService paymentAccountService;
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String toLogin(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }
    
    @RequestMapping("/register")
    public String toRegister(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }
    
    @RequestMapping(value="/validate", method=RequestMethod.POST)
    public String loginUser(@ModelAttribute("user") User user, Model model)
    {
        List<User> users = this.userService.getByEmail(user.getEmail());
        if(users.size() == 1)
        {
            if(user.getUserpass().equals(users.get(0).getUserpass()))
            {
                return "redirect:/home";
            }
        }
        return "login";
    }
    
    @RequestMapping(value="/verify", method=RequestMethod.POST)
    @ResponseStatus(value=HttpStatus.OK)
    public String registerUser(@ModelAttribute("user") User user, Model model)
    {
        if((!user.getEmail().equals("")) && (!user.getUserpass().equals("")) && (!user.getFname().equals("")) && (!user.getLname().equals("")))
        {
            List<User> users = this.userService.getByEmail(user.getEmail());
            if(users.size() < 1)
            {
                user.setEnabled(true);
                user.setUserType(User.UserType.CUSTOMER);
                String pass = user.getUserpass();
                user.setUserpass(new BCryptPasswordEncoder().encode(pass));
                this.userService.save(user);
                user.setUserpass(pass);
                return "login";
            }
            else
            {
                model.addAttribute("feedback", String.format("User with email %s already exists", user.getEmail()));
                return "register";
            }
        }
        else
        {
            model.addAttribute("feedback", "Please fill out all fields");
            return "register";
        }
    }
    
    @RequestMapping("/home")
    public String toHome(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ACCOUNTMANAGER")))
        {
            List<PaymentAccount> accountList = paymentAccountService.listAll();
            model.addAttribute("accountList", accountList);
        }
        else
        {
            User user = userService.getByEmail(auth.getName()).get(0);
            List<PaymentAccount> accountList = paymentAccountService.getByUserId(user.getUserID());
            model.addAttribute("accountList", accountList);
        }
        if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("LOANOFFICER")))
        {
            List<Loan> loanList = loanService.listAll();
            model.addAttribute("loanList", loanList);
        }
        else
        {
            User user = userService.getByEmail(auth.getName()).get(0);
            List<Loan> loanList = loanService.getByUserId(user.getUserID());
            model.addAttribute("loanList", loanList);
        }
        return "home";
    }

    
    @RequestMapping("/settings")
    public String toSettings(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByEmail(auth.getName()).get(0);
        model.addAttribute("user", user);
        return "settings";
    }
    
    
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user, Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User existingUser = userService.getByEmail(auth.getName()).get(0);
        user.setUserID(existingUser.getUserID());
        if(user.getFname().equals(""))
        {
            user.setFname(existingUser.getFname());
        }
        if(user.getLname().equals(""))
        {
            user.setLname(existingUser.getLname());
        }
        if(user.getEmail().equals(""))
        {
            user.setEmail(existingUser.getEmail());
        }
        if(user.getUserpass().equals(""))
        {
            user.setUserpass(existingUser.getUserpass());
        }
        else
        {
            user.setUserpass(new BCryptPasswordEncoder().encode(user.getUserpass()));
        }
        user.setUserType(existingUser.getUsertype());
        this.userService.save(user);
        System.out.println(user.getFname());
        System.out.println(user.getLname());
        System.out.println(user.getEmail());
        System.out.println(user.getUserpass());
        System.out.println(user.getUsertype());
        System.out.println(user.getUserID());
        return "redirect:/home";
    }

    
    
    
    @RequestMapping("/logout")
    public String logout()
    {
        return "/login";
    }
}