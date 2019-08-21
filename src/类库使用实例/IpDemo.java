package 类库使用实例;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/21
 */
public class IpDemo {
    public static void main(String[] args) {
        String str = "192.168.1.123";
        System.out.println(EmailValidator.validateIP(str));

    }
}
class EmailValidator{
    public static boolean validateIP(String ip){
        if (ip == null || "".equals(ip)) {
            return false;
        }
        String regex = "([12]?[0-9]?[0-9]\\.){3}([12]?[0-9]?[0-9])";
        if (ip.matches(regex)) {//通过验证,需要对ip地址拆分处理
            String result[] = ip.split("\\.");
            for (int i = 0; i < result.length; i++) {
                int temp = Integer.parseInt(result[i]);
                if (temp > 255) {
                    return false;
                }

            }
        } else {
            return false;
        }
        return true;
    }
}