package com.twu.library.models;

import com.twu.library.enums.ProductStatus;

public abstract class Product {

    String title;
    int year;
    ProductStatus productStatus;

    public Product() {

    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }


}
