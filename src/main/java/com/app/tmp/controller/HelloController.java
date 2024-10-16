package com.app.tmp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

  @GetMapping("/api/hello")
  public String test() {
    return "backend !!!";
  }

}
