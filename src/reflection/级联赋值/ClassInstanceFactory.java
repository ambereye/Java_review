package reflection.级联赋值;

/**
 * TODO
 * AttributeAutoAssignment
 *
 * @author ambereye
 * @date 2019/9/1
 */
public class ClassInstanceFactory {
    private ClassInstanceFactory(){}
    public static <T> T create(Class<?> clazz,String value){
        try {
            Object obj = clazz.getDeclaredConstructor().newInstance();
            BeanUtils.setValue(obj, value);
            return (T) obj;
        } catch (Exception e) {
            return null;
        }
    }

}
