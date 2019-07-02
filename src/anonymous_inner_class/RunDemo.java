package anonymous_inner_class;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/7/2
 */
public class RunDemo {
    public static void main(String[] args) {
        Outer out = new Outer();// 实例化外部类
        out.fun();// 调用外部类方法

        IChannel channel = new ChannelImpl();
        channel.send(((ChannelImpl)channel).new MessageImpl());
    }
}
