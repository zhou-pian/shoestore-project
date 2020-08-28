package com.ssm.shoestoreproject.domin;

import lombok.Data;

@Data
public class UserOrders extends UserInfo {
    private Integer userId;
    private Double price;
    private Integer orderId;
    private Double userSave;
    private Double amount;
    private String status;
    private String shoePicture;
    private Integer quantity;
    private Integer shoeId;
    private String shoeName;
    private String shoeStyle;
    private Integer shoeSize;
    private String oistatus;
    private Integer orderItemId;

    public UserOrders(Integer orderId, Double price, Integer shoeSize, String shoePicture, String shoeName, String shoeStyle) {
        this.price = price;
        this.orderId = orderId;
        this.shoePicture = shoePicture;
        this.shoeName = shoeName;
        this.shoeSize = shoeSize;
        this.shoeStyle = shoeStyle;
    }


    public UserOrders(int orderId, int shoeId, int quantity) {
        this.orderId = orderId;
        this.shoeId = shoeId;
        this.quantity = quantity;
    }

    public UserOrders(Integer orderItemId, Integer orderId, Integer shoeId, Integer quantity, String status){
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.shoeId = shoeId;
        this.quantity = quantity;
        this.status = status;
    }


    public UserOrders(Integer orderId, Double price, Integer shoeId) {
        this.orderId = orderId;
        this.price = price;
        this.shoeId = shoeId;

    }

    public UserOrders(Integer orderId, Integer userId, Double amount, String oistatus, Integer shoeId, String shoePicture, String shoeName, Double price, Integer shoeSize, String shoeStyle, Integer orderItemId) {

        this.orderId = orderId;
        this.userId = userId;
        this.amount = amount;
        this.oistatus = oistatus;
        this.shoeId = shoeId;
        this.shoePicture = shoePicture;
        this.shoeName = shoeName;
        this.price = price;
        this.shoeSize = shoeSize;
        this.shoeStyle = shoeStyle;
        this.orderItemId = orderItemId;

    }

    public UserOrders(int orderId, String oistatus) {
        this.orderId = orderId;
        this.oistatus = oistatus;
    }

    public UserOrders(int userId, double amount, String oistatus) {
        this.userId = userId;
        this.amount = amount;
        this.oistatus = oistatus;
    }

    public UserOrders(int userId, double userSave){
        this.userId = userId;
        this.userSave = userSave;
    }
    public UserOrders(Integer userId, String userName, String userPasswd, String userContact, Double userSave, String userAdd, int userId1, int orderId, Double amount, String oistatus, int quantity, int shoeId, String shoeName, String shoeStyle, Integer shoeSize) {
        super(userId, userName, userPasswd, userContact, userSave, userAdd);
        this.userId = userId1;
        this.orderId = orderId;
        this.amount = amount;
        this.oistatus = oistatus;
        this.quantity = quantity;
        this.shoeId = shoeId;
        this.shoeName = shoeName;
        this.shoeStyle = shoeStyle;
        this.shoeSize = shoeSize;
    }

    public String getShoePicture() {
        return shoePicture;
    }

    public void setShoePicture(String shoePicture) {
        this.shoePicture = shoePicture;
    }
}
