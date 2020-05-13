package productManager;

import product.Product;
import product.productList.AirConditioner;
import product.productList.TV;
import productFile.ProductFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements ProductManager, Editor {
    public  String account;
    public  String password;
    private int privilege;

    private ProductFile productFile;
    private ProductTypeChecking productTypeChecking=new ProductTypeChecking();
    public User(){

    }
    public User(int privilege) {
        productFile = new ProductFile();
        this.privilege = privilege;
        if (privilege == 1) {
            account="vanhuan";
            password="vanhuan";

        } else {
            account="lehuan";
            password="lehuan";
        }
    }

    @Override
    public boolean edit(String id,ArrayList<Product> list) throws IOException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductCode().equals(id)) {
                if (productTypeChecking.isTV(list.get(i))) {
                    TV newTV = (TV) list.get(i);
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("enter productName:");
                    String newName = scanner.next();
                    newTV.setName(newName);

                    System.out.println("enter price:");
                    int newPrice = scanner.nextInt();
                    newTV.setPrice(newPrice);

                    System.out.println("enter code id :");
                    String newProductCode = scanner.next();
                    newTV.setProductCode(newProductCode);
                    System.out.println("enter inch:");
                    int newInch = scanner.nextInt();
                    newTV.setInch(newInch);
                    productFile.writeIntoFile(list,"D:\\codegym\\modul2\\caseStudy\\project\\fileUser");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void add(Product newProduct,ArrayList<Product> list) {
        list.add(newProduct);
    }

    @Override
    public void delete(String id,ArrayList<Product> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductCode().equals(id)) {
                list.remove(i);
            }
        }
    }

    @Override
    public void display(ArrayList<Product> list) {
        for (int i = 0; i < list.size(); i++) {
            if (productTypeChecking.isTV(list.get(i))) {
                TV tv=(TV) list.get(i);
                System.out.println(tv.toString());
            }else {
                AirConditioner airConditioner=(AirConditioner) list.get(i);
                System.out.println(airConditioner.toString());
            }

        }
    }
}
