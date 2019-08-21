package 类库使用实例;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/21
 */
public class StringBufferDemo {
    /**
     * 倒叙输入a到z,删除前5个字母
     * @param args
     */
    public static void main(String[] args) {
        StringBuffer buf = new StringBuffer();
        for (int i = 'a'; i < 'z'; i++) {
            buf.append((char) i);
        }
        buf.reverse().delete(0, 5);//反转处理
        System.out.println(buf);
    }
}
