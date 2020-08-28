package com.ssm.shoestoreproject.service;

import com.ssm.shoestoreproject.domin.ShoeInfoShoppingcar;
import com.ssm.shoestoreproject.domin.ShoppingCarPlus;
import com.ssm.shoestoreproject.mapper.ShoppingCarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCarService {

    @Autowired
    private ShoppingCarMapper shoppingCarMapper;

    public List<ShoppingCarPlus> findShoppingCarByUser(Integer userId){
        return shoppingCarMapper.findShoppingCarByUser(userId);
    }

    public ShoppingCarPlus findShoppingCarById(Integer shoppingcarId){
        return shoppingCarMapper.findShoppingCarById(shoppingcarId);
    }

    public int setQuantity1(Integer shoppingcarId){
        return shoppingCarMapper.setQuantity1(shoppingcarId);
    }

    public int setQuantity2(Integer shoppingcarId){
        return shoppingCarMapper.setQuantity2(shoppingcarId);
    }

    public Integer getShoeId(Integer shoppingcarId){
        return shoppingCarMapper.getShoeId(shoppingcarId);
    }

    public Integer getQuantity(Integer shoppingcarId){
        return shoppingCarMapper.getQuantity(shoppingcarId);
    }

    public void deleteshoppingcar(Integer shoppingcarId){
        shoppingCarMapper.deleteshoppingcar(shoppingcarId);
    }

    //显示购物车
    public List<ShoeInfoShoppingcar> showshoppingcar(int userId){
        List<ShoeInfoShoppingcar> shoeInfoShoppingcars = shoppingCarMapper.showshoppingcar(userId);
        return shoeInfoShoppingcars;
    }
}
