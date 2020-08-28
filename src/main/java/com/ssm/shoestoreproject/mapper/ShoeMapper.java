package com.ssm.shoestoreproject.mapper;

import com.ssm.shoestoreproject.domin.ShoeInfo;
import com.ssm.shoestoreproject.domin.ShoePlus;
import com.ssm.shoestoreproject.domin.ShoppingCar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoeMapper {

    public List<ShoePlus> findAll();

    public ShoeInfo findById(String shoeId);

    public int insertShoe(ShoeInfo shoeInfo);

    public int updateShoe(ShoeInfo shoeInfo);

    public int deleteShoe(Integer shoeId);

    public int deliverShoe(Integer shoeId);

    public Double getPrice(Integer shoeId);

    public void updatesoldnumber(Integer quantity,Integer shoeId);

    public void updatesoldnumber1(Integer quantity,Integer shoeId);

    //显示全部的鞋
    public List<ShoeInfo> ShowAllShoes();
    //显示单个鞋的具体信息
    public List<ShoeInfo> ShowOneShoe(String shoeName);
    public ShoeInfo ShowOneShoeById(int shoeId);

    //单个鞋添加购物车
    public int OneaddShoppingCar(ShoppingCar shoppingCar);
    public ShoppingCar findCarByuIdandsId(int userId,int shoeId);
    public int updateCarByuIdandsId(int userId,int shoeId);


    //根据鞋名模糊查询鞋
    public List<ShoeInfo> SelectShoeByName(String shoeName);
}
