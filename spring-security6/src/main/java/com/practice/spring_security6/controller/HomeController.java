package com.practice.spring_security6.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  @GetMapping("")
    public  String home(){
      return "Lets practice spring security";
  }

  @GetMapping("/csrf")
  public CsrfToken getToken(HttpServletRequest request){
    return (CsrfToken) request.getAttribute("_csrf");
  }
}

