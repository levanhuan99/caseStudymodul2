package productManager;

import product.Product;
import product.productList.AirConditioner;
import product.productList.TV;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {
    ArrayList<Product> list=new ArrayList<>();
    Product tv1=new TV("tv1",100,"001",25);
    Product tv2=new TV("tv2",100,"002",30);
    Product airConditioner1=new AirConditioner("airConditioner1",100,"003","2");
    Product airConditioner2=new AirConditioner("airConditioner2",200,"004","1");

    @org.junit.jupiter.api.Test
    void edit() {


    }

    @org.junit.jupiter.api.Test
    void add() {

    }

    @org.junit.jupiter.api.Test
    void delete() {

    }

    @org.junit.jupiter.api.Test
    void display() {

    }
}