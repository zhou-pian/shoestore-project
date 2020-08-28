package com.ssm.shoestoreproject.service;

import com.ssm.shoestoreproject.domin.OrderItemPlus;
import com.ssm.shoestoreproject.domin.OrdersPlus;
import com.ssm.shoestoreproject.domin.UserOrders;
import com.ssm.shoestoreproject.mapper.UserOrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrdersService {
    @Autowired
    private UserOrdersMapper userOrdersMapper;

    //判断账户余额是否足够，否则，删除刚刚建立的订单
    public void deletenosaveorder(Integer orderId){
        userOrdersMapper.deletenosaveorder(orderId);
    }

    public List<OrdersPlus> findAllOrders(Integer userId){
        return userOrdersMapper.findAllOrders(userId);
    }

    public List<OrderItemPlus> findOrderItem(Integer orderId){
        return userOrdersMapper.findOrderItem(orderId);
    }

    //个人发起退货
    public int UserupdateStatus1(Integer orderItemId){
        return userOrdersMapper.UserupdateStatus1(orderItemId);
    }
}
