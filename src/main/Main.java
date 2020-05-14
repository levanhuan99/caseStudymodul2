package main;

import accountManager.AccountManager;
import product.Product;
import product.productList.AirConditioner;
import product.productList.TV;
import productFile.ProductFile;
import productManager.User;

import java.io.IOException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static AccountManager accountManager=new AccountManager();
    public static void main(String[] args) throws IOException {
        Service service = new Service();
        service.run();
//        String account1="";
//        String password="";
//        HashMap<String,String> account=new HashMap<>();
//        account=accountManager.getInformation();
//        for (Map.Entry<String,String> s:account.entrySet()){
//            account1=s.getKey();
//            password=s.getValue();
//            System.out.println(account1+" "+password);
//        }


    }
}
