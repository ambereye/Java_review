package 类库使用实例;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/21
 */
public class EmailDemo {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("输入错误");
            //System.exit(1);//退出系统
        }
//        String email = args[0];
        String email = "baiud@163.com";
        if (Validator.isEmail(email)) {
            System.out.println("正确");
        } else {
            System.out.println("错误");
        }
    }
}

class Validator{
    private Validator(){}
    public static boolean isEmail(String eamil){
        if (eamil == null||"".equals(eamil)) {
            return false;
        }
        String regex = "\\w+@\\w+\\.\\w+";
        return eamil.matches(regex);//是返回是否匹配指定的字符串，如果匹配则为true,否则为false;

    }
}