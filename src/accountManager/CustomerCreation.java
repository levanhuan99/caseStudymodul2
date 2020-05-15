package accountManager;

import productManager.UserManager;

import java.util.Scanner;

public class CustomerCreation {
    public UserManager customer;
    public AccountManager accountManager=new AccountManager();

    public UserManager getPrivilege(){

        Scanner scanner=new Scanner(System.in);
        System.out.println("welcom sir!");
        System.out.println("enter account please.");
        String customerAccount = scanner.next();
        System.out.println("enter password");
        String customerPassword = scanner.next();

        if(customerAccount.equals("lehuan1")&&customerPassword.equals("123")){
            customer=new UserManager(1);
            return customer;
        }else if (customerAccount.equals("lehuan2")&&customerPassword.equals("1234")){
            customer=new UserManager(2);
            return customer;
        }else if (customerAccount.equals("lehuan3")&&customerPassword.equals("12345")){
            customer=new UserManager(3);
            return customer;
        }
        return null;
    }
}
