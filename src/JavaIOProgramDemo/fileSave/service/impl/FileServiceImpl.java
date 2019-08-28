package JavaIOProgramDemo.fileSave.service.impl;

import JavaIOProgramDemo.compareNumber.InputUtil;
import JavaIOProgramDemo.fileSave.service.IFileService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/28
 */
public class FileServiceImpl implements IFileService {
    private String name;
    private String content;

    public FileServiceImpl(){
        this.name = InputUtil.getString("请保存文件名称:");
        this.content = InputUtil.getString("请保存文件内容:");
    }

    @Override
    public boolean save() {
        File file = new File(IFileService.SAVE_DIR + this.name);
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileOutputStream(file));
            out.print(this.content);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            return false;
        } finally {
            if (out!=null){
                out.close();
            }
        }
        return true;
    }
}
