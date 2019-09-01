package reflection;

import lambda.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/1
 */
public class MethodDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class cls = Person.class;
        Package aPackage = cls.getPackage();
        System.out.println(aPackage.getName());//获取包
        System.out.println(cls.getSuperclass().getName());//获取父类
        /**
         *  getInterface  获得接口
         *  实例化方法替代:clazz.getDeclaredConstrutor().newInstance
         *  获取所有的构造方法: public Constructor<?>  [] getDeclaredConstrutors
         *  获取指定构造方法: getDeclaredConstrutor
         *  获取所有的构造方法 getConstrutors
         *  获取指定构造方法: getConstrutor
          */

        /**
         *  获得方法
         *  获取本类所有的方法: public Method[] getDeclaredMethods
         *  获取本类指定方法: getDeclaredMethod
         *  获取所有的方法 Method[] getMethods()
         *  获取指定方法: getMethod()
         */
        /**
         *  获得成员
         *  获取所有的成员: public Field[] getDeclaredFields
         *  获取指定成员: getDeclaredFields
         *  获取本类所有的成员 Field[] getFields()
         *  获取本类指定成员: getFields()
         */
        //实例化对象之后
        // 1set设置属性内容
        // 2get获取属性内容
        // 3setAccessible 解除封装  构造/方法/成员
        Class<?> clsa = Class.forName("lambda.Person");//获取指定class对象
        Object o = clsa.getConstructor().newInstance();//实例化对象(分配成员空间
        Field namefield = clsa.getDeclaredField("name");//获取成员对象
        namefield.set(o,"哈哈哈");//等价于 Person对象.setName("哈哈哈") Person对象.name = "哈哈哈";
        System.out.println(namefield.get(o));

        // Filed类获取成员类型是最常见的 getType

        //unsafe 可以绕过JVM获取实例化对象  调用其方法
    }
}
