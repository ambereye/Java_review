package inOutPutStream;

import java.io.*;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/25
 */
public class ReadDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "Hello.text");
        if (file.exists()) {
            Reader reader = new FileReader(file);
            char  data[] = new char[1024];
            int len = reader.read(data);
            System.out.println("读取内容:" + new String(data, 0, len));
            reader.close();
        }
    }

}
