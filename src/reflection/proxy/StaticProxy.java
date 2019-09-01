package reflection.proxy;

/**
 * TODO
 *  静态代理
 * @author ambereye
 * @date 2019/9/1
 */
public class StaticProxy {
    public static void main(String[] args) {
        IMessage msg = new MessageProxy(new MessageReal());
        msg.send();
    }

}


class MessageProxy implements IMessage{//代理类
    private IMessage message;//代理对象,一定是业务接口实例
    public MessageProxy(IMessage message) {
        this.message = message;
    }

    @Override
    public void send() {
        if (this.connect()) {
            this.message.send();
            this.close();
        }
    }

    private boolean connect(){return true;}
    private void close(){}
}

interface IMessage{//传统代理设计必须有接口
    public void send();
}

class MessageReal implements IMessage{
    @Override
    public void send() {
        System.out.println("发送消息:开始发送");
    }
}

