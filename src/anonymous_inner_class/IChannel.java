package anonymous_inner_class;

/**
 * TODO
 *  内部接口
 * @author ambereye
 * @date 2019/7/2
 */
public interface IChannel {
    void send(IMessage msg);
    interface IMessage{
        public String getContent();
    }
}
