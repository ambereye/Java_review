package inOutPutStream;

import java.io.*;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/25
 */
public class OutPutStreamDemo {
    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "Hello.text");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try (OutputStream outputStream = new FileOutputStream(file,true)) {
            String str = "this is the last chance\r\n";
            outputStream.write(str.getBytes());
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 是否使用自动关闭取决于项目结构

    }
}
