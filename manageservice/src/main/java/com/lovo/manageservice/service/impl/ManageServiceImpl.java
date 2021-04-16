package com.lovo.manageservice.service.impl;

import com.alibaba.fastjson.JSON;

import com.lovo.api.bean.skuBean;
import com.lovo.manageservice.Util.RedisUtil;
import com.lovo.manageservice.mapper.ManageMapper;
import com.lovo.manageservice.service.ManageService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;


@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    ManageMapper manageMapper;
    @Autowired
    RedisUtil redisUtil;



    @Override
    public void addSku(skuBean skuBean) {

        manageMapper.addSku(skuBean);
    }

    @Override
    public List<skuBean> getSku() {
        return manageMapper.getAllSku();
    }

    @Override
    public skuBean getSkuById(String id) {
        skuBean skuBean = new skuBean();

        Jedis jedis = redisUtil.getJedis();
        String skuInfo = jedis.get("SkuId:" + id + "info:");
        if (StringUtils.isNotBlank(skuInfo)){
            System.err.println("从《缓存》中获取商品详情!");

            skuBean = JSON.parseObject(skuInfo, skuBean.class);
        }else {
            System.err.println("从数据库中获取商品详情!");
            skuBean = manageMapper.getSkuById(id);
            jedis.set("SkuId:" + id + "info:", JSON.toJSONString(skuBean));
        }

        return skuBean;
    }
}
