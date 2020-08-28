package com.ssm.shoestoreproject.domin;

import lombok.Data;

@Data
public class OrderItemPlus extends OrderItem {
    private String shoeName;
    private String shoePicture;
    private Double price;
    private Integer shoeSize;
    private String userName;
    private String userContact;
    private String userAdd;

    public OrderItemPlus(Integer orderItemId, Integer orderId, Integer shoeId, Integer quantity) {
        super(orderItemId, orderId, shoeId, quantity);
    }

    public OrderItemPlus(Integer shoeId, Integer orderId, Integer quantity) {
        super(shoeId, orderId, quantity);
    }

    public OrderItemPlus(Integer orderItemId, Integer orderId, Integer shoeId, Integer quantity,String status, String userName, String userContact, String userAdd,String shoePicture) {
        super(orderItemId, orderId, shoeId, quantity,status);
        this.userName = userName;
        this.userContact = userContact;
        this.userAdd = userAdd;
        this.shoePicture = shoePicture;
    }

    public OrderItemPlus(Integer shoeId, Integer orderId, Integer quantity, String shoeName, String shoePicture, Double price, Integer shoeSize, String userName, String userContact, String userAdd) {
        super(shoeId, orderId, quantity);
        this.shoeName = shoeName;
        this.shoePicture = shoePicture;
        this.price = price;
        this.shoeSize = shoeSize;
        this.userName = userName;
        this.userContact = userContact;
        this.userAdd = userAdd;
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

    public Integer getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(Integer shoeSize) {
        this.shoeSize = shoeSize;
    }
}
