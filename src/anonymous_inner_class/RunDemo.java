package anonymous_inner_class;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/7/2
 */
public class RunDemo {
    public static void main(String[] args) {
        // 实例化外部类
        Outer out = new Outer();
        out.fun();// 调用外部类方法

        IChannel channel = new ChannelImpl();
        channel.send(((ChannelImpl)channel).new MessageImpl());

        IChannel channel1 = IChannel.getInstance();
        channel1.send1();

        //匿名内部类
        IMessage.getInstance().send("匿名内部类实现");
    }
}
