package accountManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountManager {


    public  HashMap<String,String> getInformation(){
        HashMap<String,String> account=new HashMap<>();
        account.put("vanson","12345");
        account.put("lehuan","12345");
        return account;
    }


}
