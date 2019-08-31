package reflection;

import anonymous_inner_class.IMessage;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/31
 */
public class JavaDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //1 object 获取
        User user = new User();
        Class<? extends User> aClass = user.getClass();
        System.out.println(aClass.getName());
        //2  jvm 直接获取
        Class<? extends User> bClass = User.class;
        System.out.println(bClass.getName());
        //3 Class类里面提供static方法  加载类forName
        Class<?> cClass = Class.forName("reflection.User");
        System.out.println(cClass.getName());

    }
}
//工厂设计模式:客户端不直接牵扯对象的实例化管理,只与接口发生关联,通过工厂类获取指定接口的实例
//解决子类与客户端的耦合问题
    class Factory{
        public Factory() {}
        public static <T> T getInstance(String classname,Class<T> clazz){
        T instance = null;
            try {
                instance = (T) Class.forName(classname).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return instance;
        }
    }
