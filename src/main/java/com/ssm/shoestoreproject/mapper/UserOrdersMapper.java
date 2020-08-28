package com.ssm.shoestoreproject.mapper;

import com.ssm.shoestoreproject.domin.OrderItemPlus;
import com.ssm.shoestoreproject.domin.OrdersPlus;
import com.ssm.shoestoreproject.domin.UserOrders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserOrdersMapper {
     //判断账户余额是否足够，否则，删除刚刚建立的订单
    public void deletenosaveorder(@Param("orderId") Integer orderId);

    //用户个人订单显示
    public List<OrdersPlus> findAllOrders(Integer userId);

    public List<OrderItemPlus> findOrderItem(@Param("orderId") Integer orderId);

    //个人发起退货
    public int UserupdateStatus1(Integer orderItemId);

}
