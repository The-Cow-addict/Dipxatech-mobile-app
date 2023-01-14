package com.dipxa.dipxatechnology;

public class product {
    private String product_name;
    private String product_price;
    private String product_description;
    Integer image_product;

    public product(String product_name, String product_price, int image_product) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.image_product = image_product;
    }

    public product(String product_name, String product_price, String product_description, Integer image_product) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_description = product_description;
        this.image_product = image_product;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public Integer getImage_product() {
        return image_product;
    }

    public void setImage_product(Integer image_product) {
        this.image_product = image_product;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    @Override
    public String toString() {
        return "product{" +
                "product_name='" + product_name + '\'' +
                ", product_price='" + product_price + '\'' +
                ", product_description='" + product_description + '\'' +
                ", image_product=" + image_product +
                '}';
    }
}
