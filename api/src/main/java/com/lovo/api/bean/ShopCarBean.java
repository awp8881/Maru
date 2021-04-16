package com.lovo.api.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ShopCarBean {

    private String id;
    private String skuId;
    private String userId;
    private BigDecimal price;
    private String skuPic;


}
