package 二叉树;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/18
 */
public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person (String name,int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public int compareTo(Person per) {
        return this.age - per.age;
    }

    @Override
    public String toString(){
        return "姓名:"+this.name+"年龄:"+this.age+"\n";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}