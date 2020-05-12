package product.productList;

import product.Product;

public class AirConditioner extends Product {
    private String way;

    public AirConditioner(String name, int price, String productCode,String way) {
        super(name, price, productCode);
        this.way=way;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(int price) {
        super.setPrice(price);
    }

    @Override
    public String getProductCode() {
        return super.getProductCode();
    }

    @Override
    public void setProductCode(String productCode) {
        super.setProductCode(productCode);
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    @Override
    public String toString() {
        return super.toString()+",this is air conditioner "+getWay()+" way";
    }
}
