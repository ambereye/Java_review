package anonymous_inner_class;

/**
 * TODO
 * 内部接口
 *
 * @author ambereye
 * @date 2019/7/2
 */
public interface IChannel {
    void send(IMessage msg);

    interface IMessage {
        public String getContent();
    }

    /**
     * 内部接口实现
     */

    void send1();

    class ChannelImpl implements IChannel {

        @Override
        public void send(IMessage msg) {
        }

        @Override
        public void send1() {
            System.out.println("内部接口实现");
        }
    }

    static IChannel getInstance(){
        return new ChannelImpl();
    }

}
