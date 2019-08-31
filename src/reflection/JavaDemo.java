package reflection;

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
