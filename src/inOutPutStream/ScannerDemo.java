package inOutPutStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * TODO
 *  扫描流
 * @author ambereye
 * @date 2019/8/26
 */
public class ScannerDemo {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("请输入年龄");
//        if(scan.hasNextInt()){ // 判断是否输入整数
//            int age = scan.nextInt();// 直接获取数字
//            System.out.println("您的年龄" + age);
//        }else{
//            System.out.println("error");
//        }
//        scan.close();
//    }
        public static void main(String[] args) throws FileNotFoundException {
            Scanner scan = new Scanner(new File("D:" + File.separator + "Hello.text"));
            scan.useDelimiter("\n");
            while (scan.hasNext()) {
                System.out.println(scan.next());
            }
            scan.close();
        }
}
