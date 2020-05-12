package productManager;

import product.Product;

public interface ProductManager {
    void add(Product newProduct);
    void delete(String id);
    void display();

}
