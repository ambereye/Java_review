package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/1
 */
public class AnnotationDemo {
    public static void main(String[] args) throws Exception {
        Method method = Message.class.getMethod("send", String.class);//获取指定方法
        DefaultAnnotion anno = method.getAnnotation(DefaultAnnotion.class);//获取指定Annotation
        String msg = anno.title() + anno.url();
        method.invoke(Message.class.getDeclaredConstructor().newInstance(), msg);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface DefaultAnnotion{
    public String title();
    public String url() default "github.com";
}

class Message{
    @DefaultAnnotion(title = "panda")
    public void send(String msg){
        System.out.println("消息发送"+msg);
    }
}
