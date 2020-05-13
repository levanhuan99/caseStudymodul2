package main;

import product.Product;
import product.productList.TV;
import productFile.ProductFile;
import productManager.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Service implements AdminCreation, Customer1Creation {
    private ProductFile productFile = new ProductFile();
    private ArrayList<Product> list = new ArrayList<>();


    public void run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("who are you?");
        System.out.println("1.admin");
        System.out.println("2.customer");
        int userOption = scanner.nextInt();
        switch (userOption) {

            case 1://admin
                list = productFile.readFile("D:\\codegym\\modul2\\caseStudy\\project\\fileAdmin");
                System.out.println("enter account");
                String adminAccount = scanner.next();
                System.out.println("enter password");
                String adminPassword = scanner.next();


                if (isUser(adminAccount, adminPassword, admin)) {
                    System.out.println("what do you want to do ?");
                    System.out.println("1.add product");
                    System.out.println("2.delete product");
                    System.out.println("3.edit product");
                    System.out.println("4.display product");
                    int adminOption = scanner.nextInt();
                    switch (adminOption) {
                        case 1:
                            System.out.println("you want to add TV or AirConditioner");
                            System.out.println("1.TV");
                            System.out.println("2.AirConditioner");
                            int choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("enter product name");
                                    String newName = scanner.next();
                                    System.out.println("enter product price");
                                    int newPrice = scanner.nextInt();
                                    System.out.println("enter product code");
                                    String newCode = scanner.next();
                                    System.out.println("enter product inch");
                                    int newInch = scanner.nextInt();
                                    Product newTV = new TV(newName, newPrice, newCode, newInch);
                                    admin.add(newTV, list);
                                    break;
                                case 2:
                                    break;
                                default:
                            }
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            admin.display(list);
                            break;
                        default:

                     productFile.writeIntoFile(list,"D:\\codegym\\modul2\\caseStudy\\project\\fileAdmin");
                    }
                }
            case 2://customer
                break;
        }
    }

    private boolean isUser(String account, String password, User user) {
        return account.equals(user.account) && password.equals(user.password);
    }


}
