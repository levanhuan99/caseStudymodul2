package productManager;

import product.Product;

import java.io.IOException;
import java.util.ArrayList;

public interface Editor {
    boolean edit(String id, ArrayList<Product> list) throws IOException;
}
