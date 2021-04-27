package com.efinance.controller;

import com.efinance.model.PaymentAccount;
import com.efinance.model.User;
import com.efinance.service.PaymentAccountService;
import com.efinance.service.PaymentService;
import com.efinance.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController
{
    @Autowired
    PaymentAccountService paymentAccountService;
    
    @Autowired
    PaymentService paymentService;
    
    @Autowired
    UserService userService;
    
    @RequestMapping("/accounts")
    public String toAccounts(Model model)
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
        return "accounts";
    }
    
    @RequestMapping("/account/{id}")
    public ModelAndView toAccount(@PathVariable(name="id") Integer id)
    {
        ModelAndView mav = new ModelAndView("account");
        PaymentAccount account = this.paymentAccountService.get(id);
        mav.addObject("account", account);
        return mav;
    }
    
    @RequestMapping("/payment/{id}")
    public ModelAndView toPayment(@PathVariable(name="id") Integer id)
    {
        ModelAndView mav = new ModelAndView("payment");
        PaymentAccount account = this.paymentAccountService.get(id);
        mav.addObject("account", account);
        return mav;
    }
}
