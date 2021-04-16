package com.lovo.carweb.controller;


import com.lovo.carweb.annotations.LoginRequired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
public class CarController {


    @RequestMapping("carList")
    @LoginRequired(loginSuccess = true)
    public String carList(String skuId){


        return "car";
    }

}
