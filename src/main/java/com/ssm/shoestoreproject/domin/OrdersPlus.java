package com.ssm.shoestoreproject.domin;

import lombok.Data;

@Data
public class OrdersPlus extends Orders {
    private String userName;
    private String userContact;
    private String userAdd;

    public OrdersPlus(Integer userId, Double amount, String status_o,String status_s) {
        super(userId, amount, status_o,status_s);
    }
}
