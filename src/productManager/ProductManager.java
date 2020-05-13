package productManager;

import product.Product;

import java.util.ArrayList;

public interface ProductManager {
    void add(Product newProduct, ArrayList<Product> list);
    void delete(String id,ArrayList<Product> list);
    void display(ArrayList<Product> list);

}
