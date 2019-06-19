package reflection;


import dto.User;

import java.lang.reflect.Field;

/**
 * 利用反射获取实体属性值
 * @author ambereye
 */
public class Reflection {

    public static boolean judgement(Object object) throws IllegalAccessException {
        boolean flag = true;

        if (null != object) {
            Class<?> objectClass = object.getClass();
            // 所有属性
            Field[] fields = objectClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(object);
                if (null == value || "".equals(value)) {
                    return false;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) throws IllegalAccessException {
        User user = new User();
        user.setName("张三");
        user.setSex("男");
        user.setAge(11);
        //user.setIdCard("111");
        System.out.println(judgement(user));
    }
}
