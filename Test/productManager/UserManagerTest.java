package productManager;

import org.junit.jupiter.api.Test;
import product.Product;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserManagerTest {
    private UserManager userManager=new UserManager();

    @Test
    void add() {
        ArrayList<Product> list=new ArrayList<>();
        int sizeExpected=1;
        Product product=new Product("sp1",100,"001");
        userManager.add(product,list);
        int sizeResult=list.size();
        assertEquals(sizeExpected,sizeResult);

    }

    @Test
    void delete() {
        ArrayList<Product> list=new ArrayList<>();
        int sizeExpected=0;
        Product product=new Product("sp1",100,"001");
        list.add(product);
        userManager.delete("001",list);
        int sizeResult=list.size();
        assertEquals(sizeExpected,sizeResult);
    }


    @Test
    void findProduct() {
        ArrayList<Product> list=new ArrayList<>();
        Product product=new Product("sp1",100,"001");
        list.add(product);
        Product product1=new Product("sp1",100,"001");
        Product resultProduct=userManager.findProduct("001",list);
        assertEquals(product,resultProduct);
    }
}