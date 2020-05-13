package main;

import product.Product;
import product.productList.AirConditioner;
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
                                    productFile.writeIntoFile(list, "D:\\codegym\\modul2\\caseStudy\\project\\fileAdmin");
                                    run();
                                    break;
                                case 2:
                                    System.out.println("enter product name");
                                    String newName1 = scanner.next();
                                    System.out.println("enter product price");
                                    int newPrice1 = scanner.nextInt();
                                    System.out.println("enter product code");
                                    String newCode1 = scanner.next();
                                    System.out.println("hom many way of this air conditioner");
                                    String newWay1 = scanner.next();
                                    Product newAirConditioner = new AirConditioner(newName1, newPrice1, newCode1, newWay1);
                                    admin.add(newAirConditioner, list);
                                    productFile.writeIntoFile(list, "D:\\codegym\\modul2\\caseStudy\\project\\fileAdmin");
                                    run();
                                    break;

                            }
                        case 2:
                            System.out.println("enter product code ");      //ok
                            String codeDelete = scanner.next();
                            admin.delete(codeDelete, list);
                            productFile.writeIntoFile(list, "D:\\codegym\\modul2\\caseStudy\\project\\fileAdmin");
                            run();
                            break;
                        case 3:
                            System.out.println("enter product code");       //ok
                            String codeEdit = scanner.next();
                            admin.edit(codeEdit, list);
                            productFile.writeIntoFile(list, "D:\\codegym\\modul2\\caseStudy\\project\\fileAdmin");
                            run();
                            break;
                        case 4:
                            admin.display(list);                            //ok
                            run();
                            break;
                    }
                }
            case 2://customer
                System.out.println("enter account");
                String customerAccount = scanner.next();
                System.out.println("enter password");
                String customerPassword = scanner.next();
                if (isUser(customerAccount,customerPassword,customer)){
                    System.out.println("what do you want to do ?");
                    System.out.println("1.add product to your cart");
                    System.out.println("2.delete product from your cart");
                    System.out.println("3.display all the product in your cart");
                    int customerOption=scanner.nextInt();
                    switch (customerOption){
                        case 1:
                            break;
                        case 2:
                            list=productFile.readFile("D:\\codegym\\modul2\\caseStudy\\project\\fileUser");
                            System.out.println("enter product code ");
                            String codeDelete = scanner.next();
                            customer.delete(codeDelete,list);
                            productFile.writeIntoFile(list,"D:\\codegym\\modul2\\caseStudy\\project\\fileUser");
                            run();
                            break;
                        case 3:
                            list=productFile.readFile("D:\\codegym\\modul2\\caseStudy\\project\\fileUser"); //ok
                            customer.display(list);
                            run();
                            break;
                    }
                }
                break;
        }
    }

    private boolean isUser(String account, String password, User user) {
        return account.equals(user.account) && password.equals(user.password);
    }


}
