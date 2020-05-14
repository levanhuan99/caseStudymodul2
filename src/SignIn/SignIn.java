package SignIn;

import java.util.Scanner;

public class SignIn {
    private Scanner scanner;
    private String account;
    private String password;

    public SignIn(){}
    public SignIn(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }
    public SignIn invoke() {
        System.out.println("enter account");
        account = scanner.next();
        System.out.println("enter password");
        password = scanner.next();
        return this;
    }
}