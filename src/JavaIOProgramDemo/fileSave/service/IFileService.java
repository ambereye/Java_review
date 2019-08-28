package JavaIOProgramDemo.fileSave.service;

import java.io.File;

public interface IFileService {
    static final String SAVE_DIR = "D:" + File.separator + "Test" + File.separator;
    /**
     * 定义文件的保存方法
     */
    boolean save();
}
