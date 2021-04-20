package com.efinance.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EfinanceErrorController implements ErrorController
{
    @Override
    public String getErrorPath()
    {
        return "/error";
    }
    
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model)
    {
        String errorPage = "/home";
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status != null)
        {
            Integer statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value())
            {
                errorPage = "/404-error";
            }
            else if(statusCode == HttpStatus.FORBIDDEN.value())
            {
                errorPage = "/403-error";
            }
        }
        return errorPage;
    }
}
