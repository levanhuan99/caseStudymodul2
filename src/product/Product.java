package product;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private int price;
    private String productCode;

    public Product(String name, int price, String productCode) {
        this.name = name;
        this.price = price;
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString(){
        return "name"+ getName()+",price "+getPrice()+",id "+getProductCode();
    }
}
