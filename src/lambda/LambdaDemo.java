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

    /**
     * 行为参数化传递代码   用 Comparator 来排序
     * @param <T>
     */
    //用 Comparator 来排序
    // java.util.Comparator
    public interface Comparator<T> {
        public int compare(T o1, T o2);
    }
    //你可以随时创建 Comparator 的实现，用 sort 方法表现出不同的行为。比如，你可以
    //使用匿名类，按照重量升序对库存排序：
        //inventory.sort(new Comparator<Apple>() {
        public int compare(Apple a1, Apple a2){
            return a1.getWeight().compareTo(a2.getWeight());
        }
    //});
    //lambda
    //inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

    /**
     * 行为参数化传递代码    用 Runnable 执行代码块
     */
    /**
     * 线程就像是轻量级的进程：它们自己执行一个代码块。但是，怎么才能告诉线程要执行哪块
     * 代码呢？多个线程可能会运行不同的代码。我们需要一种方式来代表稍候执行的一段代码。在
     * Java里，你可以使用 Runnable 接口表示一个要执行的代码块。请注意，代码不会返回任何结果
     */
    // java.lang.Runnable
    //public interface Runnable{
    //    public void run();
    //}
    //你可以像下面这样，使用这个接口创建执行不同行为的线程：
    //Thread t = new Thread(new Runnable() {
    //    public void run(){
    //        System.out.println("Hello world");
    //   }
    //});
    //用Lambda表达式的话，看起来是这样：
    //Thread t = new Thread(() -> System.out.println("Hello world"));

    /**
     * 行为参数化传递代码    GUI 事件处理
     */
    /**
     * 如果用户单击“发送”按钮，你可能想显示一个弹出式窗口，或把行为记录在一个文件中。
     * 你还是需要一种方法来应对变化；你应该能够作出任意形式的响应。在JavaFX中，你可以使用
     * EventHandler ，把它传给 setOnAction 来表示对事件的响应：
     */
    /**
     *     Button button = new Button("Send");
     *     button.setOnAction(new EventHandler<ActionEvent>() {
     *         public void handle(ActionEvent event) {
     *             label.setText("Sent!!");
     *         }
     *     });
     *     这里， setOnAction 方法的行为就用 EventHandler 参数化了。用Lambda表达式的话，看
     *     起来就是这样：
     *             button.setOnAction((ActionEvent event) -> label.setText("Sent!!"));
     */

}
