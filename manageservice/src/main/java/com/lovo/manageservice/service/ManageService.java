package com.lovo.manageservice.service;

import com.lovo.api.bean.skuBean;

import java.util.List;

public interface ManageService {
    public  void  addSku(skuBean skuBean);


    List<skuBean> getSku();

    skuBean getSkuById(String id);
}
