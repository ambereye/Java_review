package inOutPutStream;

import java.io.*;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/25
 */
class FileUtil {
    private File srcFile;
    private File desFile;

    public FileUtil(File srcFile, File desFile) {
        this.srcFile = srcFile;
        this.desFile = desFile;
    }

    public FileUtil(String src, String des) {
        this(new File(src), new File(des));
    }

    /**
     * 目录拷贝
     *
     * @return
     * @throws IOException
     */
    public boolean copyDir() throws Exception {

        try {
            this.copyImpl(this.srcFile);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void copyImpl(File file) throws Exception {
        if (file.isDirectory()){//是目录
            File results[] = file.listFiles();//列出全部目录组成
            if(results != null){
                for (int i = 0; i < results.length; i++) {
                    copyImpl(results[i]);
                }
            }
        }else{//文件
            System.out.println(file);
            String newFilePath = file.getPath().replace(this.desFile.getPath()+File.separator,"");
            File newFile = new File(this.desFile,newFilePath); //拷贝的目标路径
            this.copyFileImpl(file,newFile);
        }
    }

    private boolean copyFileImpl(File srcFile, File desFile) throws Exception {
        if (!desFile.getParentFile().exists()) {
            desFile.getParentFile().mkdirs();//创建父目录
        }
        byte data[] = new byte[1024];// 开辟一个新缓冲区
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(srcFile);
            output = new FileOutputStream(desFile);
            int len = 0;
            // 读取数据到数组之中 返回读取个数
            // 判断是否-1 如果不是进行写入
            while ((len = input.read(data)) != -1) {
                output.write(data, 0, len);
            }
            //jdk(1.9)
            //input.transferTo(output);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
        return false;
    }

    /**
     * 文件拷贝
     *
     * @return
     * @throws IOException
     */
    public boolean copy() throws Exception {
        if (!this.srcFile.exists()) {//文件不存在
            System.out.println("不存在");
            return false;
        }
        return this.copyFileImpl(this.srcFile, this.desFile);

    }
}

public class CopyFileDemo {
    public static void main(String[] args) throws Exception {
//        String a[] = {"D:" + File.separator + "哈哈哈"+File.separator +"Hello.txt", "D:"+File.separator+"Hello2.txt"};
          String a[] = {"D:" + File.separator + "哈哈哈", "D:"+File.separator+"测试"};
        if (a.length != 2) {
            System.out.println("命令执行错误");
        }
        long start = System.currentTimeMillis();
        FileUtil fu = new FileUtil(a[0], a[1]);
        if (new File(a[0]).isFile()) { //文件拷贝
            System.out.println(fu.copy() ? "文件拷贝成功":"失败");
        } else {
            System.out.println(fu.copyDir() ? "目录文件拷贝成功":"失败");
        }
        long end = System.currentTimeMillis();
        System.out.println("时间" + (end - start));
    }
}
