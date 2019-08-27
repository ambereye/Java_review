package JavaIOProgramDemo.compareNumber;

import JavaIOProgramDemo.compareNumber.factory.Factory;
import JavaIOProgramDemo.compareNumber.service.INumberService;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/27
 */
public class IOCaseDemo {
    public static void main(String[] args) {
        INumberService numberService = Factory.getInstance();
        int result[] = numberService.state(5);
        System.out.println("最大值:"+result[0]+"最小值:"+result[1]);
    }
}
