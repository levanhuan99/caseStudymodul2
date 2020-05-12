package productFile;

import product.Product;

import java.io.*;
import java.util.ArrayList;

public class ProductFile {

    private static final String SOURCE_FILE_ADMIN ="D:\\codegym\\modul2\\caseStudy\\project\\src\\productFile\\products" ;

    public ArrayList<Product> readFromFileAdmin() {
        ArrayList<Product> store = new ArrayList<>();

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Object obj = null;
        try {
            fis = new FileInputStream(SOURCE_FILE_ADMIN);
            ois = new ObjectInputStream(fis);

            while (fis.available() > 0) {
                obj = ois.readObject();
                store.add((Product) obj);
            }
            return store;
        } catch (Exception e) {
            System.out.println("loi o doc file " + e);
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println("loi o class product io doc file try catch 2 " + e);
            }
            try {
                ois.close();
            } catch (IOException e) {
                System.out.println("loi o class product io try catch 2 " + e);
            }
        }
        return null;
    }

    public void writeIntoFileAdmin(ArrayList<Product> list) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        Object obj = null;
        try {
            fos = new FileOutputStream(SOURCE_FILE_ADMIN);
            oos = new ObjectOutputStream(fos);
            for (int i = 0; i < list.size(); i++) {
                obj = list.get(i);
                oos.writeObject(obj);
            }
        } catch (Exception e) {
            System.out.println("loi o ghi file " + e);
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println("loi o class product io ghi file try catch 2 " + e);
            }
            try {
                oos.close();
            } catch (IOException e) {
                System.out.println("loi o class product io ghi file try catch 2 " + e);
            }
        }
    }
    public void readFromFileUser(String SOURCE_FILE_USER) throws IOException {//trả về ArrayList<Product>
//        BufferedReader bufferedReader = null;
////        String line="";
//        FileReader fileReader = null;
//        String[] countries;
//
//
//        try {
//            fileReader = new FileReader(SOURCE_FILE_USER);
//            bufferedReader = new BufferedReader(fileReader);
//            while ((bufferedReader.readLine()) != null) {
//                countries = bufferedReader.readLine().split(",");
//                System.out.println(countries);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            bufferedReader.close();
//        }


    }
    public void writeIntoFileUser(ArrayList<Product> list){
    }

}
