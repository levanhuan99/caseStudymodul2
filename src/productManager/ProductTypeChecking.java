package productManager;

import product.Product;
import product.productList.TV;

public class ProductTypeChecking {
    public boolean isTV(Product product){
        if (product instanceof TV){
            return true;
        }
        return false;
    }
}
