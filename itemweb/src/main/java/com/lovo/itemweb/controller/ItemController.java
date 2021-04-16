package com.lovo.itemweb.controller;


import com.lovo.api.bean.skuBean;
import com.lovo.api.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
public class ItemController {

    @Autowired
    ManageService manageService;


    @RequestMapping("{skuId}.html")
    public String item(@PathVariable("skuId") String skuId, ModelMap modelMap){

        skuBean skuById = manageService.getSkuById(skuId);
        modelMap.put("skuInfo",skuById);
        return "item";
    }
}
