package lambda;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/7/3
 */
public class Person {
    private String name;
    private int age;

    public Person (String name,int age){
    this.name=name;
    this.age=age;
    }
    @Override
    public String toString(){
        return "姓名:"+this.name+"年龄:"+this.age;
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
