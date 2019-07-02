package anonymous_inner_class;

/**
 * 匿名内部类
 */
public interface IMessage {
    void send(String str);
    public static IMessage getInstance(){
        return new IMessage() {
            @Override
            public void send(String str) {
                System.out.println(str);
            }
        };
    }
}
