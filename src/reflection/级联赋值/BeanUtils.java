package reflection.级联赋值;



import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/1
 */
public class BeanUtils {
    public BeanUtils() {
    }

    public static void setValue(Object obj, String value) {
        String results[] = value.split("\\|");
        for (int x = 0; x < results.length; x++) {
            String attval[] = results[x].split(":");
            try {
                if (attval[0].contains(".")) {
                    String temp[] = attval[0].split("\\.");
                    Object currentObject = obj;
                    for (int y = 0; y < temp.length - 1; y++) {
                        Method getMethod = currentObject.getClass().getDeclaredMethod("get" + StringUtils.initcap(temp[y]));
                        Object tempObject = getMethod.invoke(currentObject);
                        if (tempObject == null) {
                            Field field = currentObject.getClass().getDeclaredField(temp[y]);
                            Method method = currentObject.getClass().getDeclaredMethod("set" + StringUtils.initcap(temp[y]), field.getType());
                            Object newObject = field.getType().getDeclaredConstructor().newInstance();
                            method.invoke(currentObject, newObject);
                            currentObject = newObject;
                        } else {
                            currentObject = tempObject;
                        }
                    }
                } else {
                    Field field = obj.getClass().getDeclaredField(attval[0]);
                    Method setMethod = obj.getClass().getDeclaredMethod("set" + StringUtils.initcap(attval[0]), field.getType());
                    Object convertValue = BeanUtils.convertAtributeValue(field.getType().getName(), attval[1]);
                    setMethod.invoke(obj, convertValue);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
    private static Object convertAtributeValue(String type,String value) {
        if("long".equals(type)||"java.lang.Long".equals(type)) {
            return Long.parseLong(value);
        }else if ("int".equals(type)||"java.lang.Integer".equals(type)) {
            return Integer.parseInt(value);
        }else if ("double".equals(type)||"java.lang.Double".equals(type)) {
            return Double.parseDouble(value);
        }else if ("java.util.Date".equals(type)) {
            SimpleDateFormat sdf = null;
            if(value.matches("\\d{4}-\\d{2}-\\d{2}")) {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            }else if (value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}-\\d{2}-\\d{2}")) {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }else {
                return new Date();
            }
            try {
                return sdf.parse(type);
            } catch (ParseException e) {
                return new Date();
            }
        }else {
            return value;
        }
    }
}