package com.ssm.shoestoreproject.domin;

import lombok.Data;

@Data
public class Orders {
    private Integer orderId;
    private Integer userId;
    private Double amount;
    private String status_o;
    private String status_s;

    public Orders(Integer userId, Double amount, String status_o,String status_s) {
        this.userId = userId;
        this.amount = amount;
        this.status_o = status_o;
        this.status_s = status_s;
    }

}
