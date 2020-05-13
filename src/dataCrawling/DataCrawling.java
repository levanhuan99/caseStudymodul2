package dataCrawling;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataCrawling {

//    public static void main(String[] args) {
//        try {
//            URL link = new URL("https://fptshop.com.vn/may-tinh-xach-tay?sort=gia-thap-den-cao");
//            Scanner scanner = new Scanner(new InputStreamReader(link.openStream()));
//            scanner.useDelimiter("\\Z");
//            String content = scanner.next();
//            scanner.close();
//            content.replaceAll("\\n", "");
//            Pattern pattern1 = Pattern.compile("title=\"(.*?)\"><span>");
//            Matcher matcher = pattern1.matcher(content);
//            while ((matcher.find())) {
//                System.out.println(matcher.group(1));
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void saveToFile() {
    }

}
