package com.kovalevskyi.academy.bootcamp.tooling.apps.portal.web.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

  @RequestMapping("/error")
  public String handleError(HttpServletRequest request, ModelMap model) {
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    Object status_text = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

    if (status != null) {
      int statusCode = Integer.parseInt(status.toString());

      if(statusCode == HttpStatus.NOT_FOUND.value()) {
        return "errors/404.html";
      }
    }

    model.addAttribute("status_code", status);
    model.addAttribute("status_text", status_text);

    return "errors/error.html";
  }

  @Override
  public String getErrorPath() {
    return null;
  }
}
