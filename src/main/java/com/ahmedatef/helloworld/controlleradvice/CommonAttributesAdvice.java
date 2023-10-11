package com.ahmedatef.helloworld.controlleradvice;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonAttributesAdvice {
    @ModelAttribute("version")
    public String version() {
        return "1.0";
    }

    @ModelAttribute("author")
    public String author() {
        return "Ahmed Atef";
    }
}
