package reflection;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 利用反射获取实体属性值
 * @author ambereye
 */
public class Reflection {

    public static boolean judgement(Object object,List<String> arr) throws IllegalAccessException {

        if (null != object) {
            Class<?> objectClass = object.getClass();
            // 获得所在类的所有字段属性
            Field[] fields = objectClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.println(field.getName());
                if(arr.contains(field.getName())){
                    Object value = field.get(object);
                    if (null == value || "".equals(value)) {
                        return false;
                    }
                }

            }
        }
        return true;
    }

    public static void main(String[] args) throws IllegalAccessException {
        User user = new User();
        user.setName("张三");
        user.setSex("男");
        user.setAge(11);
        //user.setIdCard("111");
        //String[] arr ={"name","sex","age"};
        List<String> arr = new ArrayList<>(Arrays.asList("name","sex","age"));
        List<String> arr1 =Arrays.asList("name","sex","age");
        System.out.println(judgement(user,arr));
    }
}
