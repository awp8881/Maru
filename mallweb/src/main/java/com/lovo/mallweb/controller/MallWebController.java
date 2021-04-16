package com.lovo.mallweb.controller;


import com.lovo.api.bean.skuBean;
import com.lovo.api.service.SearchService;
import com.netflix.client.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/mall")
public class MallWebController {


    @Autowired
    SearchService searchService;


    @RequestMapping("list/get/")
    public String list(@RequestParam("search") String search,ModelMap modelMap){
        List<skuBean> list = searchService.getList(search);
        modelMap.put("skuLsInfoList",list);
        return "list";
    }


    @RequestMapping("index")
    public String index(){
        return "/main";
    }





}
