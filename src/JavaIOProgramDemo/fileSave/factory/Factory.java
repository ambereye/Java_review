package JavaIOProgramDemo.fileSave.factory;

import JavaIOProgramDemo.compareNumber.service.INumberService;
import JavaIOProgramDemo.compareNumber.service.impl.NumberServiceImpl;
import JavaIOProgramDemo.fileSave.service.IFileService;
import JavaIOProgramDemo.fileSave.service.impl.FileServiceImpl;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/27
 */
public class Factory {
    public Factory() {}
    public static IFileService getInstance(){
        return new FileServiceImpl();
    }
}
