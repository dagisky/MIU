package com.example.eazybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @GetMapping
    public String saveContactInquiryDetails(String input){
        return "Inquiry Details are saved in the DB";
    }
}
