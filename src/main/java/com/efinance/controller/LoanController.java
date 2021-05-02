package com.efinance.controller;

import com.efinance.details.CustomUserDetails;
import com.efinance.model.Loan;
import com.efinance.model.PaymentAccount;
import com.efinance.model.User;
import com.efinance.service.LoanService;
import com.efinance.service.PaymentAccountService;
import com.efinance.service.UserService;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoanController
{
    @Autowired
    LoanService loanService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    PaymentAccountService paymentAccountService;
    
    @RequestMapping("/apply")
    public String toApply(Model model)
    {
        Loan loan = new Loan();
        model.addAttribute("loan", loan);
        return "apply";
    }
    
    @RequestMapping("/loans")
    public String toLoans(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
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
        return "loans";
    }
    
    @RequestMapping("/review-loan/{id}")
    public ModelAndView toReviewLoan(@PathVariable(name="id") Integer id)
    {
        ModelAndView mav = new ModelAndView("review-loan");
        Loan loan = this.loanService.get(id);
        mav.addObject("loan", loan);
        return mav;
    }
    
    @RequestMapping("apply-confirmation")
    public String toApplyConfirmation(Model model)
    {
        return "apply-confirmation";
    }
    
    @RequestMapping("loan-approval-confirmation")
    public String toLoanApprovalConfirmation(Model model)
    {
        return "loan-approval-confirmation";
    }
    
    @RequestMapping("loan-denial-confirmation")
    public String toLoanDenialConfirmation(Model model)
    {
        return "loan-denial-confirmation";
    }
    
    @RequestMapping("/submit-application")
    public String submitApplication(@ModelAttribute("loan") Loan loan, Model model)
    {
        if((loan.getLoanType() != null) && (loan.getInterestRate() > 0) && (loan.getInterestRate() < 100) && (loan.getAmountUSD() > 0))
        {
            Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
            String email = ((UserDetails)loggedInUser.getPrincipal()).getUsername();
            loan.setBorrower(userService.getByEmail(email).get(0));
            loan.setLoanApprovalDate(null);
            loan.setIsApproved(false);
            loanService.save(loan);
            return "redirect:/apply-confirmation";
        }
        else
        {
            model.addAttribute("feedback", "Information missing or incorrect.  Please revise loan application.");
            return "apply";
        }
    }
    
    @RequestMapping("/review-loan/{id}/approve")
    public String approveLoan(@PathVariable(name="id") Integer id)
    {
        Loan loan = this.loanService.get(id);
        loan.setIsApproved(true);
        loan.setLoanApprovalDate(new Date());
        loanService.save(loan);
        PaymentAccount account = new PaymentAccount();
        account.setAccountManager(this.userService.get(58));
        account.setLoan(loan);
        paymentAccountService.save(account);
        return "redirect:/loan-approval-confirmation";
    }
    
    @RequestMapping("/review-loan/{id}/deny")
    public String denyLoan(@PathVariable(name="id") Integer id)
    {
        Loan loan = loanService.get(id);
        loan.setIsApproved(false);
        loan.setLoanApprovalDate(new Date());
        loanService.save(loan);
        return "redirect:/loan-denial-confirmation";
    }  
}