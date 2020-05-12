package productManager;

import product.Product;
import product.productList.AirConditioner;
import product.productList.TV;
import productFile.ProductFile;

import java.util.ArrayList;
import java.util.Scanner;

public class Users implements ProductManager {
    private ArrayList<Product> list=new ArrayList<>();
    private ProductFile productFile;
    public Users(){
        productFile=new ProductFile();
    }

    @Override
    public void add(Product newProduct) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void display() {

    }
}
