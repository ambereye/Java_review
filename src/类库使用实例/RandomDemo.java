package 类库使用实例;

import java.util.Arrays;
import java.util.Random;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/21
 */
public class RandomDemo {
    public static void main(String[] args) {
        int result[] = NumberFactory.create(5);
        System.out.println(Arrays.toString(result));
    }
}
class NumberFactory{
    private static Random random = new Random();

    /**
     * 通过随机数来生成一个数组的内容,但内容不包括有0
     * @param len
     * @return
     */
    public static int [] create (int len){
        int data[] = new int[len];
        int foot = 0;
        while (foot<data.length){
            int num = random.nextInt(30);
            if (num != 0){
                data[foot++] = num;
            }
        }
        return data;
    }
}
