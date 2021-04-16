package com.lovo.api.bean;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class skuBean {


    private String id;
    private String name;
    private BigDecimal price;
    private String pic;


}
