package javabaseclasslibrary;

import java.util.regex.Pattern;

/**
 * TODO
 *  正则处理,用java.util.regex
 *  其中包含两个类Patter(正则表达式编译)/Matcher(匹配)
 * @author ambereye
 * @date 2019/7/29
 */
public class regexDemo {
    public static void main(String[] args) {
        String s = "asdsfvcb.;l;poytgd,.sedfsazee[dasdcxz";
        String regex = "[^a-zA-Z]+";
        Pattern pat = Pattern.compile(regex);
        String result[] = pat.split(s);
        for (String a : result){
            System.out.println(a);
        }
    }
}
