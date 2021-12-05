package com.example.eazybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myAccount")
public class AccountController {
    @GetMapping
    public String getAccountDetails(String input){
        return "This is account details from the DB";
    }
}
