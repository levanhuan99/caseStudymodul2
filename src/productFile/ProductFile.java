package productFile;

import product.Product;
import product.productList.TV;
import productManager.ProductTypeChecking;

import java.io.*;
import java.util.ArrayList;

public class ProductFile {
    private  ProductTypeChecking productTypeChecking=new ProductTypeChecking();


    public ArrayList<Product> readFile(String path) {
        ArrayList<Product> store=new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Object obj = null;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);

            while (fis.available() > 0) {
                obj = ois.readObject();
                store.add((Product) obj);
            }
            fis.close();
            ois.close();
            return store;
        } catch (Exception e) {
            System.out.println("loi o doc file " + e);
        }
        return null;
    }

    public void writeIntoFile(ArrayList<Product> list, String path) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        Object obj = null;
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            for (int i = 0; i < list.size(); i++) {
                obj = list.get(i);
                oos.writeObject(obj);
            }
        } catch (Exception e) {
            System.out.println("loi o ghi file " + e);
        } finally {
            fos.close();
            oos.close();
        }
    }
}
