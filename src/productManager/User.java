package productManager;

import product.Product;
import product.productList.AirConditioner;
import product.productList.TV;
import productFile.ProductFile;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements ProductManager, Editor {

    private ArrayList<Product> list = new ArrayList<>();
    private ProductFile productFile;
    private ProductTypeChecking productTypeChecking;

    public Admin() {
        productFile = new ProductFile();
        list = productFile.readFromFileAdmin();
    }

    @Override
    public void edit(String id) {
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
                    double newInch = scanner.nextDouble();
                    newTV.setInch(newInch);
                }
            }
        }
    }

    @Override
    public void add(Product newProduct) {
        list.add(newProduct);
    }

    @Override
    public void delete(String id) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductCode().equals(id)) {
                list.remove(i);
            }
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < list.size(); i++) {
            if (productTypeChecking.isTV(list.get(i))) {
                System.out.println(list.get(i).toString());
            }
            System.out.println(list.get(i).toString());
        }
    }

    public boolean isAdmin(String account, String password) {
        return (account.equals("vanhuan") && password.equals("vanhuan"));
    }
}
