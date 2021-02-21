/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efinance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController
{
    @RequestMapping("/hello")
    public String sayHello(Model model)
    {
        System.out.println("Greetings");
        model.addAttribute("message", "hello");
        return "hello";
    }
}