package javabaseclasslibrary;

import sun.misc.Cleaner;

/**
 * TODO
 * 1.9之后提供的对象清理操作 主要进行finialize()替代
 * c++中有两种特殊的函数 :构造函  析构(对象手工回收)
 *
 * @author ambereye
 * @date 2019/7/22
 */
class Member implements Runnable {
    public Member() {
        System.out.println("构造,panda生成了");
    }

//    @Override
//    protected void finalize() throws Throwable {
//        System.out.println("回收,你死啦");
//        throw new Exception("");
//    }
    //上面注释内容替换成以下

    @Override
    public void run() {
        System.out.println("回收,你死啦");
    }
}

//class MemeberCleaning implements AutoCloseable {// 实现清除处理
//    private static final Cleaner cleaner = Cleaner.create();//创建清除处理
//    private static Member member;
//    private static Cleaner.Cleanable cleanable;
//
//    public MemeberCleaning() {
//        this.member = new Member();//创建新对象
//        this.cleanable = this.cleaner.register(this, this.member);
//    }
//
//    @Override
//    public void close() throws Exception {
//        this.cleanable.clean();//启动多线程
//    }
//
//}
//
//public class CleanerDemo {
//    public static void main(String[] args) {
////        Member men = new Member();
////        men = null;
////        System.gc();
//        //上面为过去操作的方式
//        try (MemeberCleaning mc = new MemeberCleaning()) {
////执行相关代码
//        }catch (Exception e){}
//    }
//}
