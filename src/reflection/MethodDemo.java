package reflection;

import lambda.Person;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/1
 */
public class MethodDemo {
    public static void main(String[] args) {
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
         *  获取所有的方法: public Method[] getDeclaredMethods
         *  获取指定方法: getDeclaredMethod
         *  获取本类所有的方法 Method[] getMethods()
         *  获取本类指定方法: getMethod()
         */


    }
}
