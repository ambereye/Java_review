package lambda;

import java.io.BufferedReader;
import java.io.IOException;

public class LambdaDemo {
    /**
     * 函数式接口，一个接口只定义了一个抽象方法，可称为函数式接口，可以用lambda简化代码。
     * Lambda表达式可以直接给赋值给变量，也可以直接作为参数传递给函数
     */
    public static void startThread(Runnable a) {
        (new Thread(a)).start();
    }

    public static void main(String[] args) {
        //1 lambda表达式可以直接赋值给变量，也可以直接以参数的形式传递给方法.
        Runnable a = () -> {
            System.out.println("Hello World,Lambda...");
        };
        //2 JDK8之前使用匿名类来实现
        Runnable b = new Runnable() {
            @Override
            public void run() {
                // 只有sout语句才是真正需要  2的其他部分都是重复的
                System.out.println("Hello World,Lambda...");
            }
        };
        //3
        startThread(a);
        //4
        startThread(() -> {
            System.out.println("Hello World,Lambda...");
        });

        // 总结以上 1=2   1+3=4
    }

}
