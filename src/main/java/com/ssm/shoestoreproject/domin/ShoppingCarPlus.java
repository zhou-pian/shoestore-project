package com.ssm.shoestoreproject.domin;

import lombok.Data;

@Data
public class ShoppingCarPlus extends ShoppingCar {
    public String shoeName;
    public String shoePicture;
    public Double price;
    public Integer shoeSize;

    public ShoppingCarPlus(Integer shoppingcarId,Integer userId, Integer shoeId, Integer quantity) {
        super(shoppingcarId,userId, shoeId, quantity);
    }

    public ShoppingCarPlus(Integer shoppingcarId,Integer userId, Integer shoeId) {
        super(shoppingcarId,userId, shoeId);
    }

    public ShoppingCarPlus(Integer shoppingcarId,Integer userId, Integer shoeId, Integer quantity, String shoeName, String shoePicture, Double price,Integer shoeSize) {
        super(shoppingcarId,userId, shoeId, quantity);
        this.shoeName = shoeName;
        this.shoePicture = shoePicture;
        this.price = price;
        this.shoeSize = shoeSize;
    }

    public ShoppingCarPlus(Integer shoppingcarId,Integer userId, Integer shoeId, String shoeName, String shoePicture, Double price, Integer shoeSize) {
        super(shoppingcarId,userId, shoeId);
        this.shoeName = shoeName;
        this.shoePicture = shoePicture;
        this.price = price;
        this.shoeSize = shoeSize;
    }

    public String getShoeName() {
        return shoeName;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    public String getShoePicture() {
        return shoePicture;
    }

    public void setShoePicture(String shoePicture) {
        this.shoePicture = shoePicture;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShoppingCarPlus{" +
                "shoeName='" + shoeName + '\'' +
                ", shoePicture='" + shoePicture + '\'' +
                ", price=" + price +
                ", shoeSize=" + shoeSize +
                "} " + super.toString();
    }
}
