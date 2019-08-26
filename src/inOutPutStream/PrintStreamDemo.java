package inOutPutStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * TODO
 *  打印流
 * @author ambereye
 * @date 2019/8/26
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:" + File.separator + "Hello.text");//定义操作文件
        PrintStream pu = new PrintStream(new FileOutputStream(file));
        String name = "amber";
        int age = 25;
        double salary = 213124.11234;
        pu.printf("姓名:%s,年龄%d,收入%9.2f",name,age,salary);
        pu.close();

    }
}
