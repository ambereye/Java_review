package JavaIOProgramDemo.compareNumber;

import java.util.Scanner;

/**
 * TODO
 *  编写,输入三个整数,求出3个整数的最大值和最小值
 *  1.定义输入工具类
 * @author ambereye
 * @date 2019/8/27
 */
public class InputUtil {
    public InputUtil() {}
    /**
     * 实现键盘接受数字操作
     */
    public static int getInt(String prompt){
        int num = 0;
        boolean flag = true;

        while(flag){
            Scanner input = new Scanner(System.in);
            System.out.println(prompt); //打印提示信息
            if(input.hasNext("\\d+")){
                num = Integer.parseInt(input.next("\\d+"));
                flag = false;
            }else{
                System.out.println("输入的内容不是数字!");
            }
        }
        return num;
    }

}
