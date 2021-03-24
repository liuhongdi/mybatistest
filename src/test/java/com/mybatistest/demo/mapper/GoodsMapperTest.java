package com.mybatistest.demo.mapper;

import com.mybatistest.demo.pojo.Goods;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("dev")
@MybatisTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GoodsMapperTest {
    @Resource
    private GoodsMapper goodsMapper;
    @Test
    void selectOneGoods() {
        Goods goodsOne = goodsMapper.selectOneGoods(3L);
        System.out.println(goodsOne);
        assertThat(goodsOne.getGoodsId(), equalTo(3L));
    }

    @Test
    void insertOneGoods() {
        Goods goodsOne = new Goods();
        //goodsOne.setGoodsId(13L);
        goodsOne.setGoodsName("商品名称xy");
        goodsOne.setSubject("商品描述");
        goodsOne.setPrice(new BigDecimal(101));
        goodsOne.setStock(13);

        int insNum = goodsMapper.insertOneGoods(goodsOne);
        assertThat(insNum, equalTo(1));

        Long goodsId = goodsOne.getGoodsId();
        //assertThat(goodsId, equalTo(14L));
        Goods goods = goodsMapper.selectOneGoods(goodsId);
        System.out.println(goods);
        //Goods goodsRet = goodsService.getOneGoodsById(14L);
        assertThat(goods.getGoodsName(), equalTo("商品名称xy"));
    }
}