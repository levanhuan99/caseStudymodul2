package productManager;
import product.Product;
import product.productList.AirConditioner;
import product.productList.TV;
import productFile.ProductFile;

import java.io.IOException;
import java.util.*;

public class UserManager implements ProductManager, Editor {
    public String account;
    public String password;
    public int privilege;

    private ProductFile productFile;
    private ProductTypeChecking productTypeChecking = new ProductTypeChecking();

    public UserManager(int privilege) {
        productFile = new ProductFile();

        this.privilege = privilege;
        switch (privilege){
            case 0:
                account = "vanhuan";
                password = "12345";
                break;
            case 1:
                account = "lehuan1";
                password = "123";
                break;
            case 2:
                account = "lehuan2";
                password = "1234";
                break;
            case 3:
                account = "lehuan3";
                password = "12345";
                break;
        }
    }

    @Override
    public void edit(String id, ArrayList<Product> list) throws IOException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductCode().equals(id)) {
                Scanner scanner = new Scanner(System.in);
                if (productTypeChecking.isTV(list.get(i))) {
                    TV newTV = (TV) list.get(i);

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

                } else {
                    AirConditioner airConditioner = (AirConditioner) list.get(i);
                    System.out.println("enter productName:");
                    String newName = scanner.next();
                    airConditioner.setName(newName);

                    System.out.println("enter price:");
                    int newPrice = scanner.nextInt();
                    airConditioner.setPrice(newPrice);

                    System.out.println("enter code id :");
                    String newProductCode = scanner.next();
                    airConditioner.setProductCode(newProductCode);

                    System.out.println("enter new way");
                    String newWay = scanner.next();
                    airConditioner.setWay(newWay);
                }
            }
        }
    }

    @Override
    public void add(Product newProduct, ArrayList<Product> list) {
        list.add(newProduct);
    }

    @Override
    public void delete(String id, ArrayList<Product> list) {
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
                TV tv = (TV) list.get(i);
                System.out.println(tv.toString());
            } else {
                AirConditioner airConditioner = (AirConditioner) list.get(i);
                System.out.println(airConditioner.toString());
            }

        }
    }

    public Product findProduct(String id, ArrayList<Product> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductCode().equals(id)) {
                return list.get(i);
            }
        }
        return null;
    }
}
