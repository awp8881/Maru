package com.lovo.mallservice.controller;


import com.lovo.api.bean.skuBean;
import com.lovo.mallservice.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MallServiceController {


    @Autowired
    SearchService searchService;

    @RequestMapping("listaaa/get/{name}")
    public List<skuBean> list(@PathVariable("name") String search){
        List<skuBean> list = searchService.getList(search);

        return list;
    }

}
