package com.example.eazybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myLoans")
public class LoansController {
    @GetMapping
    public String getLoanDetails(String input){
        return "Here are the loan details from the DB";
    }
}
