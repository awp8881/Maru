package com.lovo.mallservice;


import com.lovo.api.bean.skuBean;
import com.lovo.api.service.ManageService;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@EnableEurekaClient
@EnableFeignClients("com.lovo.api.service")
public class MallServiceApplicationTests {

    @Autowired
    ManageService manageService;

    @Autowired
    JestClient jestClient;


    @Test
    public void contextLoads() throws IOException {
        put();
        //get();
    }
    public void put() throws IOException {

        // 查询mysql数据
        List<skuBean> skuBeanList = new ArrayList<>();

        skuBeanList = manageService.getAllSku();

        // 转化为es的数据结构

        // 导入es
        for (skuBean skuBean : skuBeanList) {
            Index put = new Index.Builder(skuBean).index("mall2020").type("AllSKU").id(skuBean.getId() + "").build();
            jestClient.execute(put);
        }

    }
}
