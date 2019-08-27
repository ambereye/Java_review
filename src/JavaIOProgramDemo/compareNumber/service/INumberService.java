package JavaIOProgramDemo.compareNumber.service;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/27
 */
public interface INumberService {
    /**
     *  输入数据返回最大值和最小值
     * @param count 表示输入数据的个数
     * @return 包含两个内容,第一个是最大值,第二个是最小值
     */
    public int[] state(int count);
}
