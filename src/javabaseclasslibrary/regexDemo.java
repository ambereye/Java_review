package javabaseclasslibrary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO
 * 正则处理,用java.util.regex
 * 其中包含两个类Patter(正则表达式编译)/Matcher(匹配)
 *
 * @author ambereye
 * @date 2019/7/29
 */
public class regexDemo {
    //Pattern
    //    public static void main(String[] args) {
//        String s = "asdsfvcb.;l;poytgd,.sedfsazee[dasdcxz";
//        String regex = "[^a-zA-Z]+";
//        Pattern pat = Pattern.compile(regex);
//        String result[] = pat.split(s);
//        for (String a : result){
//            System.out.println(a);
//        }
//    }
    //matcher
//    public static void main(String[] args) {
//        String s = "101";
//        String regex = "\\d+";
//        Pattern pat = Pattern.compile(regex);
//        Matcher mat = pat.matcher(s);
//        System.out.println(mat.matches());
//    }
    // replace
//    public static void main(String[] args) {
//        String s = "wjkasjASDAS123[]asd";
//        String regex = "\\D+";
//        Pattern pat = Pattern.compile(regex);
//        Matcher mat = pat.matcher(s);
//        System.out.println(mat.replaceAll(""));
//    }
    // 分组功能
        public static void main(String[] args) {
        String str = "Insert into dept(deptno,dname,loc) VALUES (#{deptno},#{name},#{loc})";
        String regex = "#\\{\\w+\\}";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(str);
        while(mat.find()){
//            System.out.println(mat.group(0));
            System.out.println(mat.group(0).replaceAll("#|\\{|\\}",""));
        }
    }

}
