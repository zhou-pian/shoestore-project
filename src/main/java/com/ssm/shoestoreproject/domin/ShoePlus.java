package com.ssm.shoestoreproject.domin;

import lombok.Data;

@Data
public class ShoePlus extends ShoeInfo {
    private String categoryName;

    public ShoePlus(String shoeName, String shoePicture, Double price, Integer inventory, Integer cId, Integer shoeSize, String shoeStyle) {
        super(shoeName, shoePicture, price, inventory, cId, shoeSize, shoeStyle);
    }

    @Override
    public String toString() {
        return "ShoePlus{" +
                "categoryName='" + categoryName + '\'' +
                "} " + super.toString();
    }
}
