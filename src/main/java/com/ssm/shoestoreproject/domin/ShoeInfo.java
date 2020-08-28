package com.ssm.shoestoreproject.domin;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShoeInfo implements Serializable {
    private Integer shoeId;
    private String shoeName;
    private String shoePicture;
    private Double price;
    private Integer inventory;
    private Integer soldNumber;
    private Integer cId;
    private Integer shoeSize;
    private String shoeStyle;

    public ShoeInfo(){

    }
    public ShoeInfo(String shoeName, String shoePicture, Double price, Integer inventory, Integer cId, Integer shoeSize, String shoeStyle) {
        this.shoeName = shoeName;
        this.shoePicture = shoePicture;
        this.price = price;
        this.inventory = inventory;
        this.cId = cId;
        this.shoeSize = shoeSize;
        this.shoeStyle = shoeStyle;
    }
    public ShoeInfo(String shoeName, String shoePicture, Double price, Integer inventory, Integer soldNumber, Integer categoryId, Integer shoeSize, String shoeStyle) {
        this.shoeName = shoeName;
        this.shoePicture = shoePicture;
        this.price = price;
        this.inventory = inventory;
        this.soldNumber = soldNumber;
        this.cId = categoryId;
        this.shoeSize = shoeSize;
        this.shoeStyle = shoeStyle;
    }

    public ShoeInfo(Integer shoeId, String shoeName, String shoePicture, Double price, Integer inventory, Integer soldNumber, Integer categoryId, Integer shoeSize, String shoeStyle) {
        this.shoeId = shoeId;
        this.shoeName = shoeName;
        this.shoePicture = shoePicture;
        this.price = price;
        this.inventory = inventory;
        this.soldNumber = soldNumber;
        this.cId = categoryId;
        this.shoeSize = shoeSize;
        this.shoeStyle = shoeStyle;
    }

    public Integer getShoeId() {
        return shoeId;
    }

    public void setShoeId(Integer shoeId) {
        this.shoeId = shoeId;
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

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(Integer soldNumber) {
        this.soldNumber = soldNumber;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(Integer shoeSize) {
        this.shoeSize = shoeSize;
    }

    public String getShoeStyle() {
        return shoeStyle;
    }

    public void setShoeStyle(String shoeStyle) {
        this.shoeStyle = shoeStyle;
    }

    @Override
    public String toString() {
        return "ShoeInfo{" +
                "shoeId=" + shoeId +
                ", shoeName='" + shoeName + '\'' +
                ", shoePicture='" + shoePicture + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                ", soldNumber=" + soldNumber +
                ", cId=" + cId +
                ", shoeSize=" + shoeSize +
                ", shoeStyle='" + shoeStyle + '\'' +
                '}';
    }
}
