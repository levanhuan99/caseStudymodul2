package main;

import product.Product;
import product.productList.AirConditioner;
import product.productList.TV;
import productFile.ProductFile;
import productManager.UserManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Service implements AdminCreation {
    private ProductFile productFile = new ProductFile();
    private ArrayList<Product> list = new ArrayList<>();
    private String fileAdmin = "D:\\codegym\\modul2\\caseStudy\\project\\fileAdmin";
    private CustomerCreation customerCreation = new CustomerCreation();

    private String fileTail = "";       //nếu implement nhiều interface của customer thì sẽ bị lỗi k biết dùng cái customer nào nên ý tưởng là dùng switch case
    private String fileCustomer = "";


    Scanner scanner = new Scanner(System.in);

    public void run() throws IOException {


        System.out.println("who are you?");
        System.out.println("1.admin");
        System.out.println("2.customer");
        System.out.println("3.sign up an account");
        System.out.println("4.exit");
        int userOption = scanner.nextInt();
        switch (userOption) {

            case 1://admin
                list = productFile.readFile(fileAdmin);
                System.out.println("enter account");
                String adminAccount = scanner.next();
                System.out.println("enter password");
                String adminPassword = scanner.next();
                if (isUser(adminAccount, adminPassword, admin)) {
                    adminChoice();
                    run();
                    break;
                }
            case 2://customer sign in
                customerCreation.getPrivilege();
                fileTail = Integer.toString(customerCreation.getPrivilege().privilege);
                fileCustomer = "D:\\codegym\\modul2\\caseStudy\\project\\fileUser" + fileTail;
                customerChoice();
                run();
                break;
            case 3:
                System.exit(0);
        }
    }

    private void customerChoice() throws IOException {
        System.out.println("what do you want to do ?");
        System.out.println("1.add product to your cart");
        System.out.println("2.delete product from your cart");
        System.out.println("3.display all the product in your cart");
        int customerOption = scanner.nextInt();
        switch (customerOption) {
            case 1:
                list = productFile.readFile(fileAdmin);//đọc từ file admin để hiển thị cho khách xem hàng
                customerCreation.customer.display(list);
                System.out.println("enter product id which you want to add to you cart");
                String id = scanner.next();                                                                   //cho khách chọn hàng theo id
                ArrayList<Product> products = new ArrayList<>();                                            //khởi tạo list mới để đọc giỏ hàng
                products = productFile.readFile(fileCustomer);
                customerCreation.customer.add(customerCreation.customer.findProduct(id, list), products);                                        //thêm sản phầm khách hàng tìm được vào list  vừa khởi tạo
                productFile.writeIntoFile(products, fileCustomer);
                customerChoice();
                break;

            case 2:
                list = productFile.readFile(fileCustomer);
                if (list.size() == 0) {
                    System.out.println("empty cart!");
                    customerChoice();
                }
                System.out.println("enter product code ");
                String codeDelete = scanner.next();
                customerCreation.customer.delete(codeDelete, list);
                productFile.writeIntoFile(list, fileCustomer);
                customerChoice();
                break;
            case 3:
                list = productFile.readFile(fileCustomer); //ok
                if (list.size() == 0) {
                    System.out.println("empty cart! add product please.");
                    customerChoice();
                }
                customerCreation.customer.display(list);
                customerChoice();
                break;
        }
    }

    private void adminChoice() throws IOException {
        System.out.println("what do you want to do ?");
        System.out.println("1.add product");
        System.out.println("2.delete product");
        System.out.println("3.edit product");
        System.out.println("4.display product");
        System.out.println("5.exit");
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
                        productFile.writeIntoFile(list, fileAdmin);
                        adminChoice();
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
                        productFile.writeIntoFile(list, fileAdmin);
                        adminChoice();
                        break;
                }
            case 2:
                System.out.println("enter product code ");      //ok
                String codeDelete = scanner.next();
                admin.delete(codeDelete, list);
                productFile.writeIntoFile(list, fileAdmin);
                adminChoice();
                break;
            case 3:
                System.out.println("enter product code");       //ok
                String codeEdit = scanner.next();
                admin.edit(codeEdit, list);
                productFile.writeIntoFile(list, fileAdmin);
                adminChoice();
                break;
            case 4:
                admin.display(list);                            //ok
                adminChoice();
                break;
            case 5:
                System.exit(0);
        }
    }

    private boolean isUser(String account, String password, UserManager userManager) {
        return account.equals(userManager.account) && password.equals(userManager.password);
    }
}
