package productManager;

import product.Product;
import productManager.ProductManager;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManagerIpl implements ProductManager,Editor {
    private ArrayList<Product> products;

    //use singleton design pattern to create a list of product TODO
    private ProductManagerIpl() {

    }

    public synchronized ArrayList<Product> getArray() {
        if (products == null) {
            products = new ArrayList<>();
        }
        return products;
    }

    @Override
    public void add(String destFile) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("bạn muốn thêm sản phẩm loại gì?");

//TODO
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void display() {
        for (Product product : products) {
            System.out.println(product);
        }
    }


    @Override
    public void edit(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductCode().equals(id)) {
                Scanner scanner = new Scanner(System.in);

            }
        }
    }
}
