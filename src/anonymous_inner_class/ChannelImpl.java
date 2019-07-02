package anonymous_inner_class;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/7/2
 */
public class ChannelImpl implements IChannel{

    @Override
    public void send(IMessage msg) {
        System.out.println("发送消息：" + msg.getContent());
    }
    class MessageImpl implements IMessage{

        @Override
        public String getContent() {
                return "BAIDU.COM";
        }
    }
}
