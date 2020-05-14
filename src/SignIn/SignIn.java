package SignIn;

import java.util.Scanner;

public class SignIn {
    private Scanner scanner;
    private String adminAccount;
    private String adminPassword;

    public SignIn(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public SignIn invoke() {
        System.out.println("enter account");
        adminAccount = scanner.next();
        System.out.println("enter password");
        adminPassword = scanner.next();
        return this;
    }
}