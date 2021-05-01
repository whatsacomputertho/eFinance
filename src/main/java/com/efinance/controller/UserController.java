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
        User user = new User();
        model.addAttribute("user", user);
        return "settings";
    }
    
    
   @RequestMapping(value="/update", method=RequestMethod.POST)
    @ResponseStatus(value=HttpStatus.OK)
    public String updateUser(@ModelAttribute("user") User user, Model model)
   {  
        user.setUserType(User.UserType.CUSTOMER);
        this.userService.save(user);
        
        return "home";
    
    }

    
    
    
    @RequestMapping("/logout")
    public String logout()
    {
        return "/login";
    }
}