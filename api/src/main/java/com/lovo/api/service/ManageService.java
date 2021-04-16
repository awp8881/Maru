package com.lovo.api.service;


import com.lovo.api.bean.skuBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("ManageService")
@Component
public interface ManageService {

    @PostMapping("saveSku")
    public void addSku(skuBean skuBean);



    @GetMapping("getAllSku")
    public List<skuBean> getAllSku();


    @GetMapping("getSkuById/{id}")
    public  skuBean getSkuById(@PathVariable("id") String id);

}
