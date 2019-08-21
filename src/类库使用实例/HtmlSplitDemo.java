package 类库使用实例;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/21
 */
public class HtmlSplitDemo {
    public static void main(String[] args) {
        String str = "<font face=\"Arial,Serif\" size=\"+2\" color=\"red\">";
        String regex = "\\w+=\"[a-zA-Z0-9,\\+]+\"";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        while (matcher.find()) {
//            String result = matcher.group(0);
//            System.out.println(result);
            String temp = matcher.group(0);
            String result[] = temp.split("=");
            System.out.println(result[0]+"\t"+result[1].replaceAll("\"",""));
        }
    }
}
