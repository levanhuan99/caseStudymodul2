package main;

import accountManager.AccountManager;

import java.io.IOException;

public class Main {
//    public static AccountManager accountManager=new AccountManager();
    public static void main(String[] args) throws IOException {
        Service service = new Service();
        service.run();

    }
}
