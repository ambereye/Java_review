package javabaseclasslibrary;

/**
 * TODO
 * 用于资源开发处理,实现资源自动关闭(释放资源)
 *
 * @author ambereye
 * @date 2019/7/22
 */

public class AutoCloseableDemo {
    public static void main(String[] args) throws Exception{

        try(IMessage nm = new NetMessage("www.baidu.com")) {
            nm.send();
        }catch(Exception e){

        }
    }
}

interface IMessage extends AutoCloseable{
    void send();
}

class NetMessage implements IMessage,AutoCloseable {
    private String message;

    public NetMessage(String message) {
        this.message = message;
    }

    public boolean open() {
        System.out.println("open|获取资源链接");
        return true;
    }

    @Override
    public void close() {
        System.out.println("close|资源链接关闭");
    }

    @Override
    public void send() {
        System.out.println("发送消息" + this.message);
    }
}
