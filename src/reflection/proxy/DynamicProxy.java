package reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO
 *  动态代理
 * @author ambereye
 * @date 2019/9/1
 */
public class DynamicProxy {
    public static void main(String[] args) {
        IMessage2 msg = (IMessage2) new MLDNProxy().bind(new MessageReal2());
        msg.send();
    }

}

class MLDNProxy implements InvocationHandler {//代理类
    private Object target;//保存业务的真实对象

    /**
     * 进行真实业务对象与代理业务对象之间的绑定处理
     * @param target 真实业务对象
     * @return Proxy生成的代理业务对象
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnData = null;
        if (this.connect()) {
            System.out.println("执行方法:" +method);
            returnData = method.invoke(this.target,args);
            this.close();
        }
        return returnData;
    }

    private boolean connect(){return true;}
    private void close(){}
}

interface IMessage2{//传统代理设计必须有接口
    public void send();
}

class MessageReal2 implements IMessage2{
    @Override
    public void send() {
        System.out.println("发送消息:开始发送");
    }
}
