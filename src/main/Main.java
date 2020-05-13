package main;

import product.Product;
import product.productList.AirConditioner;
import product.productList.TV;
import productFile.ProductFile;
import productManager.User;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Service service = new Service();
        service.run();
//        ProductFile productFile=new ProductFile();
//        ArrayList<Product> list=new ArrayList<>();
//        list=productFile.readFile("D:\\codegym\\modul2\\caseStudy\\project\\fileAdmin");
//        User user=new User();
//        user.display(list);



    }
}
