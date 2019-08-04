package Base64加密解密;

import java.util.Base64;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/4
 */

class StringUitl {
    private static final String SALT = "MI_MA"; // 公共盐值
    private static final int PEPEAT = 5; // 加密次数

    public static String encode(String str) { // 加密
        String temp = str + "{" + SALT + "}"; // 盐值不公布
        byte data[] = temp.getBytes(); // 将字符串编程字节数组
        for (int i = 0; i < PEPEAT ; i++) {
            data = Base64.getEncoder().encode(data);// 重复加密
        }
        return new String(data);
    }

    public static String decode(String str) { // 解密
        byte data[] = str.getBytes();
        for (int i = 0; i < PEPEAT; i++) {
            data = Base64.getDecoder().decode(data);// 重复加密
        }
        return new String(data).replaceAll("\\{\\w+\\}","");
    }
}

public class APIDemo {
    public static void main(String[] args) {
        String str = StringUitl.encode("this is secret");
        System.out.println(str);
        System.out.println(StringUitl.decode(str));
    }


}
