package productManager;

import product.Product;
import product.productList.AirConditioner;
import product.productList.TV;
import productFile.ProductFile;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements ProductManager,Editor {
    private ArrayList<Product> list=new ArrayList<>();
    private ProductFile productFile;

    public Admin(){
        productFile=new ProductFile();
    }

    @Override
    public void edit(String id) {

    }

    @Override
    public void add(String destFile) {
        list=productFile.readFromFileAdmin();
        System.out.println("ban muốn thêm sản phẩm j vào cửa  hàng?");
        System.out.println("1.TV");
        System.out.println("1.điều hòa");
        Scanner scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("nhập tên ");
                String newName=scanner.next();
                System.out.println("nhập giá ");
                int newPrice=scanner.nextInt();
                System.out.println("nhập code của sản phẩm ");
                String newProductCode=scanner.next();
                System.out.println("nhập inch ");
                double newInch=scanner.nextDouble();
                Product newTV=new TV(newName,newPrice,newProductCode,newInch);
                list.add(newTV);
                productFile.writeIntoFileAdmin(list);
                break;
            case 2:
                System.out.println("nhập tên ");
                String newName1=scanner.next();
                System.out.println("nhập giá ");
                int newPrice1=scanner.nextInt();
                System.out.println("nhập code của sản phẩm ");
                String newProductCode1=scanner.next();

                System.out.println("điểu hòa mấy chiểu? ");
                String newWay=scanner.next();
                Product newAirConditioner=new AirConditioner(newName1,newPrice1,newProductCode1,newWay);
                list.add(newAirConditioner);
                productFile.writeIntoFileAdmin(list);
                break;
            default:
                System.out.println("không hợp lệ");
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void display() {

    }
}
