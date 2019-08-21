package 类库使用实例;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/21
 */
public class FindResourDemo {
    public static void main(String[] args) {
        if(args.length !=1){

        }

        int a = 1;
        System.out.println(new MessageUtil().getMessage(a));
    }
}

class MessageUtil{
    public static final int CHINA = 1;
    public static final int USA = 2;
    private static final String KEY = "info";
    private static final String BASENAME = "zzx.resource.Message";

    public String getMessage(int num){
        Locale loc = this.getLocale(num);
        if (loc == null) {
            return "nothing";
        } else {
            return ResourceBundle.getBundle(BASENAME, loc).getString(KEY);
        }
    }
    private Locale getLocale(int num){
        switch (num){
            case CHINA:
                return new Locale("zh", "CN");
            case USA:
                return new Locale("en", "US");

                default:
                    return null;
        }

    }
}
