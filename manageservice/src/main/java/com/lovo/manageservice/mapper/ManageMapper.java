package com.lovo.manageservice.mapper;


import com.lovo.api.bean.skuBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ManageMapper {

    public void addSku(skuBean skuBean);

    List<skuBean> getAllSku();

    skuBean getSkuById(String id);
}
