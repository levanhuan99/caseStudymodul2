package product.productList;

import product.Product;

public class TV extends Product {
    private double inch;

    public TV(String name, int price, String productCode,double inch) {
        super(name, price, productCode);
        this.inch=inch;
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

    public double getInch() {
        return inch;
    }

    public void setInch(double inch) {
        this.inch = inch;
    }

    @Override
    public String toString() {
        return super.toString()+",this is TV "+getInch()+" inch";
    }
}
