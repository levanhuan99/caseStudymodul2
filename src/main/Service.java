package main;

import SignIn.SignIn;
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
    private String fileAdmin = "D:\\codegym\\modul2\\caseStudy\\project\\fileAdmin";
    private String fileCustomer = "D:\\codegym\\modul2\\caseStudy\\project\\fileUser";


    public void run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("who are you?");
        System.out.println("1.admin");
        System.out.println("2.customer");
        System.out.println("3.sign up an account");
        System.out.println("4.exit");
        int userOption = scanner.nextInt();
        switch (userOption) {

            case 1://admin
                list = productFile.readFile(fileAdmin);
                SignIn signIn = new SignIn(scanner).invoke();
                String adminAccount = signIn.getAdminAccount();
                String adminPassword = signIn.getAdminPassword();

                if (isUser(adminAccount, adminPassword, admin)) {
                    System.out.println("what do you want to do ?");
                    System.out.println("1.add product");
                    System.out.println("2.delete product");
                    System.out.println("3.edit product");
                    System.out.println("4.display product");
                    int adminOption = scanner.nextInt();
                    switch (adminOption) {
                        case 1:
                            EnterNameAndPriceAndCode enterNameAndPriceAndCode = null;
                            System.out.println("you want to add TV or AirConditioner");
                            System.out.println("1.TV");
                            System.out.println("2.AirConditioner");
                            int choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    enterNameAndPriceAndCode = new EnterNameAndPriceAndCode(scanner).invoke();
                                    String newName = enterNameAndPriceAndCode.getNewName();
                                    int newPrice = enterNameAndPriceAndCode.getNewPrice();
                                    String newCode = enterNameAndPriceAndCode.getNewCode();
                                    System.out.println("enter product inch");
                                    int newInch = scanner.nextInt();
                                    Product newTV = new TV(newName, newPrice, newCode, newInch);
                                    admin.add(newTV, list);
                                    productFile.writeIntoFile(list, fileAdmin);
                                    run();
                                    break;
                                case 2:
                                    enterNameAndPriceAndCode = new EnterNameAndPriceAndCode(scanner).invoke();
                                    String newName1 = enterNameAndPriceAndCode.getNewName();
                                    int newPrice1 = enterNameAndPriceAndCode.getNewPrice();
                                    String newCode1 = enterNameAndPriceAndCode.getNewCode();
                                    System.out.println("hom many way of this air conditioner");
                                    String newWay1 = scanner.next();
                                    Product newAirConditioner = new AirConditioner(newName1, newPrice1, newCode1, newWay1);
                                    admin.add(newAirConditioner, list);
                                    productFile.writeIntoFile(list, fileAdmin);
                                    run();
                                    break;
                            }
                        case 2:
                            System.out.println("enter product code ");      //ok
                            String codeDelete = scanner.next();
                            admin.delete(codeDelete, list);
                            productFile.writeIntoFile(list, fileAdmin);
                            run();
                            break;
                        case 3:
                            System.out.println("enter product code");       //ok
                            String codeEdit = scanner.next();
                            admin.edit(codeEdit, list);
                            productFile.writeIntoFile(list, fileAdmin);
                            run();
                            break;
                        case 4:
                            admin.display(list);                            //ok
                            run();
                            break;
                    }
                }
            case 2://customer sign in
                System.out.println("enter account");
                String customerAccount = scanner.next();
                System.out.println("enter password");
                String customerPassword = scanner.next();
                if (isUser(customerAccount, customerPassword, customer)) {
                    System.out.println("what do you want to do ?");
                    System.out.println("1.add product to your cart");
                    System.out.println("2.delete product from your cart");
                    System.out.println("3.display all the product in your cart");
                    int customerOption = scanner.nextInt();
                    switch (customerOption) {
                        case 1:
                            list = productFile.readFile(fileAdmin);//đọc từ file admin để hiển thị cho khách xem hàng
                            customer.display(list);
                            System.out.println("enter product id which you want to add to you cart");
                            String id = scanner.next();                                                                   //cho khách chọn hàng theo id
                            ArrayList<Product> products = new ArrayList<>();                                            //khởi tạo list mới để đọc giỏ hàng
                            products = productFile.readFile(fileCustomer);
                            customer.add(customer.findProduct(id, list), products);                                        //thêm sản phầm khách hàng tìm được vào list  vừa khởi tạo
                            productFile.writeIntoFile(products, fileCustomer);
                            run();
                            break;
                        case 2:
                            list = productFile.readFile(fileCustomer);
                            if (list.size() == 0) {
                                System.out.println("empty cart!");
                                run();
                            }
                            System.out.println("enter product code ");
                            String codeDelete = scanner.next();
                            customer.delete(codeDelete, list);
                            productFile.writeIntoFile(list, fileCustomer);
                            run();
                            break;
                        case 3:
                            list = productFile.readFile(fileCustomer); //ok
                            if (list.size() == 0) {
                                System.out.println("empty cart! add product please.");
                                run();
                            }
                            customer.display(list);
                            run();
                            break;
                    }
                }
                break;
            case 3:
                //String newAccount = new SignIn(scanner).invoke();


                break;
            case 4:
                System.exit(0);
        }
    }

    private boolean isUser(String account, String password, User user) {
        return account.equals(user.account) && password.equals(user.password);
    }

    private class EnterNameAndPriceAndCode {
        private Scanner scanner;
        private String newName;
        private int newPrice;
        private String newCode;

        public EnterNameAndPriceAndCode(Scanner scanner) {
            this.scanner = scanner;
        }

        public String getNewName() {
            return newName;
        }

        public int getNewPrice() {
            return newPrice;
        }

        public String getNewCode() {
            return newCode;
        }

        public EnterNameAndPriceAndCode invoke() {
            System.out.println("enter product name");
            newName = scanner.next();
            System.out.println("enter product price");
            newPrice = scanner.nextInt();
            System.out.println("enter product code");
            newCode = scanner.next();
            return this;
        }
    }


}
