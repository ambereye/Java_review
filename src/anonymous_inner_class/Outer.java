package anonymous_inner_class;

/**
 * TODO
 * 匿名内部类
 * @author ambereye
 * @date 2019/7/2
 */
public class Outer {
    private String msg="消息";
    public void fun(){
        Inner in = new Inner();// 实例化内部类对象
        in.print();// 内部类方法
    }
    class Inner{
        public void print(){
            System.out.println(msg);
        }
    }
}
