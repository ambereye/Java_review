package fileOpera;

import java.io.File;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/25
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("D:" + File.separator);
        lisDir(file);
    }

    private static void lisDir(File file) {
        if(file.isDirectory()){
            File results [] = file.listFiles(); //列出目录所有内容
            if(results != null){
                for (int i = 0; i < results.length; i++) {
                    lisDir(results[i]); //递归判断
                }
            }
            System.out.println(file);
            //file.delete();  删除
        }
    }
}
