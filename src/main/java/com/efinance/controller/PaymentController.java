package com.efinance.controller;

import com.efinance.model.Payment;
import com.efinance.model.PaymentAccount;
import com.efinance.model.User;
import com.efinance.service.PaymentAccountService;
import com.efinance.service.PaymentService;
import com.efinance.service.UserService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        Payment payment = new Payment();
        mav.addObject("payment", payment);
        return mav;
    }
    
    @RequestMapping("/payment-confirmation")
    public String toPaymentConfirmation(Model model)
    {
        return "payment-confirmation";
    }
    
    @RequestMapping("/submit-payment/{id}")
    public String submitPayment(@PathVariable(name="id") Integer id, @ModelAttribute("payment") Payment payment, Model model)
    {
        if(payment.getPaymentAmountUSD() > 0)
        {
            PaymentAccount account = this.paymentAccountService.get(id);
            payment.setPaymentDate(new Date());
            payment.setAccount(account);
            this.paymentService.save(payment);
            return "redirect:/payment-confirmation";
        }
        else
        {
            model.addAttribute("feedback", "Please add a payment amount greater than $0.00");
            return "payment";
        }
    }
}
