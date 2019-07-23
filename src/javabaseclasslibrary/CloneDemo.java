package javabaseclasslibrary;

/**
 * TODO
 * 对象的克隆
 * @author ambereye
 * @date 2019/7/23
 */
public class CloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Members memberA = new Members("熊猫",66);
        Members memberB = (Members) memberA.clone();
        System.out.println(memberA);
        System.out.println(memberB);
    }
}

class Members implements Cloneable{
    private String name;
    private int age;

    public Members(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString()+"neme=" + this.name +"age="+this.age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // 调用父类的克隆方法
    }
}