package com.example.i18ndemo.controller;

import com.example.i18ndemo.utils.I18nUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller("/test")
public class TestController {

    @GetMapping("/testI8n")
    public String testI8n(){
        return I18nUtil.getCnByKey("favEmail.upw_favourite_list");
    }

}
