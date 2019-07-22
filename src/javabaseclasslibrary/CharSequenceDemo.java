package javabaseclasslibrary;

/**
 * TODO
 * 涉及字符串
 * @author ambereye
 * @date 2019/7/22
 */
public class CharSequenceDemo {
    public static void main(String[] args) {
        CharSequence str = "www.baidu.com"; // 子类向父接口转型
        CharSequence sub = str.subSequence(4,8);
        System.out.println(sub);
    }
    // charAt 获取指定索引字符
    // length 获取长度
    // subSequence 截取部分字符串
}
