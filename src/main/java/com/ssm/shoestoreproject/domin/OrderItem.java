package com.ssm.shoestoreproject.domin;

import lombok.Data;

@Data
public class OrderItem {
    private Integer orderItemId;
    private Integer orderId;
    private Integer shoeId;
    private Integer quantity;
    private String status;

    public OrderItem(Integer orderItemId, Integer orderId, Integer shoeId, Integer quantity, String status) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.shoeId = shoeId;
        this.quantity = quantity;
        this.status = status;
    }

    public OrderItem(Integer orderItemId, Integer orderId, Integer shoeId, Integer quantity) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.shoeId = shoeId;
        this.quantity = quantity;
    }

    public OrderItem(Integer shoeId, Integer orderId, Integer quantity) {
        this.shoeId = shoeId;
        this.orderId = orderId;
        this.quantity = quantity;
    }
}
