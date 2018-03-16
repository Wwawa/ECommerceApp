package com.oum.e_commerceapp.modal;

/**
 * Created by User on 3/15/2018.
 */

public class ProductDomain {

    String productName;
    int imageId;
    String productPrice;

    public ProductDomain(){

    }

    public ProductDomain(String productName,int imageId,String productPrice) {

        this.productName = productName;
        this.productPrice = productPrice;
        this.imageId = imageId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}

