package designPatterns;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/7/1
 */
public class SingletonDemo
{
    public static void main(String[] args) {
        Singleton instance = null;
        instance = Singleton.getInstance();
        instance.print();//饿汉式
        instance.print1();//懒汉式 存在

        MultipleDesign multipleDesign = MultipleDesign.getInstance("red");
        System.out.println(multipleDesign.toString());
    }
}
