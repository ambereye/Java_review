package fileOpera;


import java.io.File;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/25
 */
public class GetFileInfo {
    public static void main(String[] args) {
        File file = new File("d:" + File.separator + "2b.jpg");
        System.out.println("文件是否可读:"+file.canRead());
        System.out.println("文件是否可写:"+file.canWrite());
        System.out.println("文件大小:"+MathUtil.round(file.length()/(double)1024/1024,2));
    }

}
class MathUtil{

    private MathUtil() {}
    public static double round(double num ,int scale){
        return Math.round(Math.pow(10,scale)*num)/Math.pow(10,scale);
    }

}
