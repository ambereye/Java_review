package JavaIOProgramDemo.compareNumber.service.impl;

import JavaIOProgramDemo.compareNumber.InputUtil;
import JavaIOProgramDemo.compareNumber.service.INumberService;
import org.omg.CORBA.INTERNAL;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/27
 */
public class NumberServiceImpl implements INumberService {
    @Override
    public int[] state(int count) {
        int result[] = new int[2];
        int data[] = new int[count];
        for (int i = 0; i <data.length ; i++) {
            data[i] = InputUtil.getInt("请输入第"+(i+1)+"个数字:");
        }
        result[0]=data[0];//最大值
        result[1]=data[0];//最小值
        for (int i = 0; i < data.length; i++) {
            if(data[i]>result[0]){
                result[0] = data[i];
            }
            if(data[i]<result[1]){
                result[1] = data[i];
            }
        }
        return result;
    }
}
