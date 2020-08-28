package com.ssm.shoestoreproject.mapper;

import com.ssm.shoestoreproject.domin.OrderItem;
import com.ssm.shoestoreproject.domin.OrderItemPlus;
import com.ssm.shoestoreproject.domin.Orders;
import com.ssm.shoestoreproject.domin.OrdersPlus;
import org.apache.ibatis.annotations.Mapper;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Mapper
public interface OrderMapper {

    public List<OrdersPlus> findAllOrders();

    public List<OrderItemPlus> findOrderItem(Integer orderId);

    public List<OrderItemPlus> findOrderByShoe(Integer shoeId);

    public Integer getShoeId(Integer orderItemId);

    public void updateStatus1(Integer orderItemId);

    public void updateStatus2(Integer orderItemId);

    public void insertOrderItem(OrderItem orderItem);

    public void insertOrder(Orders orders);

    public Integer getOrderId(String status_s);

    public String getStatus_o(Integer orderId);

    public Double getAmount(Integer orderId);

    public void updateStatus_o(Integer orderId);

    public void updateStatus_s(Integer orderId);

    public void deleteorder(Integer orderId);

    public Integer getquantity(Integer orderItemId);

    public Integer getUserId(Integer orderId);
}
