package com.lovo.api.service;


import com.lovo.api.bean.skuBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient("MallService")
@Component
public interface SearchService {


    @GetMapping("listaaa/get/{name}")
    public List<skuBean> getList(@PathVariable("name") String search);

}
