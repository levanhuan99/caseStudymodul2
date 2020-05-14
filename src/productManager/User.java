package productManager;

import productFile.ProductFile;

import java.util.HashMap;
import java.util.Map;

public class User {
    public String account;
    public String password;
    private int privilege;
    public User(int privilege) {

        this.privilege = privilege;
        if (privilege == 1) {
            account = "vanhuan";
            password = "12345";

        } else if (privilege==0){
            account = "123";
            password = "123";
        }else if(privilege==2){
            account = "456";
            password = "456";
        }else if (privilege==3){
            account = "789";
            password = "789";
        }

    }

}
