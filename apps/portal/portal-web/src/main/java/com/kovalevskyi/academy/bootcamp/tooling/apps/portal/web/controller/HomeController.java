package com.kovalevskyi.academy.bootcamp.tooling.apps.portal.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String sayHello() {
    return "home.html";
  }
}
