package reflection.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import sun.plugin2.message.Message;

import java.lang.reflect.Method;


/**
 * TODO
 *  除了使用动态代理通过基于接口来实现,CGLIB可以基于类来操作
 * @author ambereye
 * @date 2019/9/1
 */
public class CGLIBProxy {
    public static void main(String[] args) {
        MessageReal realObject = new MessageReal(); //真实主体对象
        Enhancer enhancer = new Enhancer(); //负责代理的操作程序类
        enhancer.setSuperclass(realObject.getClass());//假定一个父类
        enhancer.setCallback(new MLDNProxy3(realObject));//设置代理类
        MessageReal proxyObject = (MessageReal) enhancer.create();//创建代理对象
        proxyObject.send();
    }

}

class MLDNProxy3 implements MethodInterceptor {//代理类
    private Object target;//保存业务的真实对象
    public MLDNProxy3(Object target){
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object returnData = null;
        if (this.connect()) {
            System.out.println("执行方法:" +method);
            returnData = method.invoke(this.target,objects);
            this.close();
        }
        return returnData;
    }
    private boolean connect(){return true;}
    private void close(){}
}

