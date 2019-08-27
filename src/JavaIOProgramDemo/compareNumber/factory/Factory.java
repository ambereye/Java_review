package JavaIOProgramDemo.compareNumber.factory;

import JavaIOProgramDemo.compareNumber.service.INumberService;
import JavaIOProgramDemo.compareNumber.service.impl.NumberServiceImpl;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/27
 */
public class Factory {
    public Factory() {}
    public static INumberService getInstance(){
        return new NumberServiceImpl();
    }
}
