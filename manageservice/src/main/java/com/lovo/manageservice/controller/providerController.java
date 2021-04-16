package com.lovo.manageservice.controller;


import com.lovo.api.bean.skuBean;
import com.lovo.manageservice.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class providerController {

    @Autowired
    ManageService manageService;

    @RequestMapping("saveSku")
    public  void  addSku(@RequestBody skuBean skuBean){
        manageService.addSku(skuBean);
    }



    @GetMapping("getAllSku")
    @ResponseBody
    public List<skuBean> getAllSku(){
        System.out.println(2);
         List<skuBean> list= manageService.getSku();
        return list;
    }


    @GetMapping("getSkuById/{id}")
    @ResponseBody
    public  skuBean getSkuById(@PathVariable("id")String id) {
        skuBean skuBean =manageService.getSkuById(id);

        return skuBean;
    }

}
