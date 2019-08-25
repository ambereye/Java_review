package inOutPutStream;

import java.io.*;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/25
 */
public class InPutStreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "Hello.text");
        InputStream input = new FileInputStream(file);
        //定长读取
        byte data[] = new byte[1024];
        int len = input.read(data);
        //全部读取(jdk1.9)
        //byte data1[] = input.readAllBytes;//注意读取不要太大10k,尽量不使用
        System.out.println("["+new String (data,0,len)+"]");
        input.close();

    }
}
