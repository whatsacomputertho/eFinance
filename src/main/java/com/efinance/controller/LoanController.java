package com.efinance.controller;

import com.efinance.details.CustomUserDetails;
import com.efinance.model.Loan;
import com.efinance.model.User;
import com.efinance.service.LoanService;
import com.efinance.service.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoanController
{
    @Autowired
    LoanService loanService;
    
    @Autowired
    UserService userService;
    
    @RequestMapping("/apply")
    public String toApply(Model model)
    {
        Loan loan = new Loan();
        model.addAttribute("loan", loan);
        return "apply";
    }
    
    @RequestMapping("/review-loan")
    public String toReviewLoan(Model model)
    {
        return "review-loan";
    }
    
    @RequestMapping("/submit-application")
    public String submitApplication(@ModelAttribute("loan") Loan loan, Model model)
    {
        if((loan.getLoanType() != null) && (loan.getInterestRate() > 0) && (loan.getInterestRate() < 100) && (loan.getAmountUSD() > 0))
        {
            Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
            String email = ((UserDetails)loggedInUser.getPrincipal()).getUsername();
            loan.setBorrower(userService.getByEmail(email).get(0));
            loanService.save(loan);
            return "redirect:/home";
        }
        else
        {
            model.addAttribute("feedback", "Information missing or incorrect.  Please revise loan application.");
            return "apply";
        }
    }
}
