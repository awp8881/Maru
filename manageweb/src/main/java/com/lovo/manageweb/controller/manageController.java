package com.lovo.manageweb.controller;



import com.lovo.api.bean.skuBean;
import com.lovo.api.service.ManageService;
import com.lovo.manageweb.Util.PmsUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Controller
public class manageController {

    @Autowired
    ManageService manageService;



    @RequestMapping("saveSku")
    public String addSku(MultipartFile pic,String skuName,String price){
        BigDecimal jiage = new BigDecimal(price);
        skuBean skuBean = new skuBean();

        String imgUrl = PmsUploadUtil.uploadImge(pic);
        skuBean.setName(skuName);
        skuBean.setPic(imgUrl);
        skuBean.setPrice(jiage);

        manageService.addSku(skuBean);

        System.out.println(imgUrl);


        return "main";
    };



    @GetMapping("getSkuById/{id}")
    public  skuBean getSkuById(@PathVariable("id")String id) {
        skuBean skuBean =manageService.getSkuById(id);

        return skuBean;
    }

    @RequestMapping("index")
    public String index(){
        return "main";
    }
}
