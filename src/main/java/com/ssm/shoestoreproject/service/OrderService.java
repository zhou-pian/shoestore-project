package com.ssm.shoestoreproject.service;

import com.ssm.shoestoreproject.domin.OrderItem;
import com.ssm.shoestoreproject.domin.OrderItemPlus;
import com.ssm.shoestoreproject.domin.Orders;
import com.ssm.shoestoreproject.domin.OrdersPlus;
import com.ssm.shoestoreproject.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public List<OrdersPlus> findAllOrders(){
        return orderMapper.findAllOrders();
    }

    public List<OrderItemPlus> findOrderItem(Integer orderId){
        return orderMapper.findOrderItem(orderId);
    }
    public List<OrderItemPlus> findOrderByShoe(Integer shoeId){
        return orderMapper.findOrderByShoe(shoeId);
    }

    public Integer getShoeId(Integer orderItemId){
        return orderMapper.getShoeId(orderItemId);
    }

    public void updateStatus1(Integer orderItemId){
        orderMapper.updateStatus1(orderItemId);
    }

    public void updateStatus2(Integer orderItemId){
        orderMapper.updateStatus2(orderItemId);
    }

    public void insertOrderItem(OrderItem orderItem){
        orderMapper.insertOrderItem(orderItem);
    }

    public void insertOrder(Orders orders){
        orderMapper.insertOrder(orders);
    }

    public Integer getOrderId(String status_s){
        return orderMapper.getOrderId(status_s);
    }

    public void updateStatus_o(Integer orderId){
        orderMapper.updateStatus_o(orderId);
    }

    public void updateStatus_s(Integer orderId){
        orderMapper.updateStatus_s(orderId);
    }

    public String getStatus_o(Integer orderId){
        return orderMapper.getStatus_o(orderId);
    }

    public Double getAmount(Integer orderId){
        return orderMapper.getAmount(orderId);
    }

    public void deleteorder(Integer orderId){
        orderMapper.deleteorder(orderId);
    }

    public Integer getquantity(Integer orderItemId){
        return orderMapper.getquantity(orderItemId);
    }

    public Integer getUserId(Integer orderId){
        return orderMapper.getUserId(orderId);
    }
}
