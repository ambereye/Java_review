package JavaIOProgramDemo.fileSave;

import JavaIOProgramDemo.fileSave.factory.Factory;
import JavaIOProgramDemo.fileSave.service.IFileService;

import java.io.File;

/**
 * TODO
 *  输入文件的内容和要保存的文件名称,然后根据输入的名称创建文件,并将内容保存到文件中
 * @author ambereye
 * @date 2019/8/27
 */
public class FileDemo {
    static {
        File file = new File(IFileService.SAVE_DIR);
        if (!file.exists()) {//文件路径不存在
            file.mkdirs();//创建
        }
    }

    public static void main(String[] args) {
        IFileService fileService = Factory.getInstance();
        System.out.println(fileService.save());
    }
}
