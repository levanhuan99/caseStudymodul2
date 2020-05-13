package productManager;

import product.Product;

import java.io.IOException;
import java.util.ArrayList;

public interface Editor {
    void edit(String id, ArrayList<Product> list) throws IOException;
}
