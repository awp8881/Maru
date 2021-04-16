package com.lovo.mallservice.service;

import com.lovo.api.bean.skuBean;

import java.util.List;

public interface SearchService {

    public List<skuBean> getList(String search);

}
