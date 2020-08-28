package com.ssm.shoestoreproject.mapper;

import com.ssm.shoestoreproject.domin.ShoeInfoShoppingcar;
import com.ssm.shoestoreproject.domin.ShoppingCarPlus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingCarMapper {

    public List<ShoppingCarPlus> findShoppingCarByUser(Integer userId);

    public ShoppingCarPlus findShoppingCarById(Integer shoppingcarId);

    public int setQuantity1(Integer shoppingcarId);

    public int setQuantity2(Integer shoppingcarId);

    public Integer getShoeId(Integer shoppingcarId);

    public Integer getQuantity(Integer shoppingcarId);

    public void deleteshoppingcar(Integer shoppingcarId);


    //显示购物车
    public List<ShoeInfoShoppingcar> showshoppingcar(int userId);
}
