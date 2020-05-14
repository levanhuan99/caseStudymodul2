package accountManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountManager {


    public  HashMap<String,String> getInformation(){
        HashMap<String,String> account=new HashMap<>();
        account.put("vanhuan","vanhuan");
        account.put("lehuan","lehuan");
        return account;
    }
    public void signUp(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter your new account");
        String account=scanner.next();
        System.out.println("enter your new password");
        String password=scanner.next();
    }

}
