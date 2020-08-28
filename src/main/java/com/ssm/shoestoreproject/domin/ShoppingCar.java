package com.ssm.shoestoreproject.domin;

import lombok.Data;

@Data
public class ShoppingCar {
    private  Integer shoppingcarId;
    private Integer userId;
    private Integer shoeId;
    private Integer quantity;

    public ShoppingCar(Integer shoppingcarId,Integer userId, Integer shoeId, Integer quantity) {
        this.shoppingcarId = shoppingcarId;
        this.userId = userId;
        this.shoeId = shoeId;
        this.quantity = quantity;
    }

    public ShoppingCar(Integer userId, Integer shoeId, Integer quantity) {
        this.userId = userId;
        this.shoeId = shoeId;
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "ShoppingCar{" +
                "shoppingcarId=" + shoppingcarId +
                ", userId=" + userId +
                ", shoeId=" + shoeId +
                ", quantity=" + quantity +
                '}';
    }
}
