package annotation;

import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;

import java.lang.reflect.Method;


/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/1
 */
public class FactoryAndAnnotation {
    public static void main(String[] args) throws Exception{
        IMessage9 msg = Factory.getInstance(MessageImpl9.class);
        msg.send("hhah1");
    }
}

class Factory{
    public Factory() {
    }
    public static <T> T getInstance(Class<T> clazz) {
        try {
            return (T)new MessageProxy().bind(clazz.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

class MessageProxy implements InvocationHandler {
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    public boolean connect(){
        System.out.println("代理操作连接");
        return true;
    }
    public void close(){
        System.out.println("代理操作关闭");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (this.connect()) {
                return method.invoke(this.target, args);
            } else {
                throw new Exception("错误");
            }
        } finally {
            this.close();

        }

    }
}

interface IMessage9{//传统代理设计必须有接口
    public void send(String msg);
}

class MessageImpl9 implements IMessage9 {
    @Override
    public void send(String msg) {
        System.out.println("发送消息:开始发送"+msg);
    }
}
