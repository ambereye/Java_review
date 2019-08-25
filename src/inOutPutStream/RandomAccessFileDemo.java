package inOutPutStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/25
 */
public class RandomAccessFileDemo {
    //写文件
//    public static void main(String[] args) throws IOException {
//        File file = new File("D:" + File.separator + "Hello.text");//定义操作文件
//        RandomAccessFile raf = new RandomAccessFile(file, "rw");//读写模式
//        String names[] = new String[]{"zhangsan", "wangwu   ", "lisi    "};
//        int ages[] = new int[]{30,20,16};
//        for (int i = 0; i < names.length; i++) {
//            raf.write(names[i].getBytes());//写入字符串
//            raf.writeInt(ages[i]);
//        }
//        raf.close();
//    }

    /**
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "Hello.text");//定义操作文件
        RandomAccessFile raf = new RandomAccessFile(file, "rw");//读写模式
        {//读李四的数据跳过24位
            raf.skipBytes(24);
            byte[] data = new byte[8];
            int len = raf.read(data);
            System.out.println("姓名:"+ new String(data,0,len)+"年龄:"+raf.readInt());
        }
            //向回跳 seek
        {//读李四的数据跳过24位
            raf.seek(12);
            byte[] data = new byte[8];
            int len = raf.read(data);
            System.out.println("姓名:"+ new String(data,0,len)+"年龄:"+raf.readInt());
        }
    }

}
