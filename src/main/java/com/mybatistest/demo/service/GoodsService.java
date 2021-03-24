package com.mybatistest.demo.service;

import com.mybatistest.demo.mapper.GoodsMapper;
import com.mybatistest.demo.pojo.Goods;
import com.mybatistest.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    //得到一件商品的信息
    public Goods getOneGoodsById(Long goodsId) {
        System.out.println("get data from mysql");
        Goods goodsOne = goodsMapper.selectOneGoods(goodsId);
        System.out.println(goodsOne);
        return goodsOne;
    }

    //添加一件商品到数据库
    public Long addOneGoods(Goods goods) {
        int insNum = goodsMapper.insertOneGoods(goods);
        if (insNum == 0) {
            return 0L;
        } else {
            Long goodsId = goods.getGoodsId();//该对象的自增ID
            return goodsId;
        }
    }
}
