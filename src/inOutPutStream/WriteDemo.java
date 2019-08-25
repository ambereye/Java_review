package inOutPutStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/25
 */
public class WriteDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "Hello.text");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Writer out = new FileWriter(file);

            String str = "this is the last chance\r\n";
            out.write(str);
            out.append("太难了"); // 追加输出内容
            out.close();

            out.flush();//强制刷新缓冲区   字节流没有用到缓冲区   字符流用到了
    }

}
