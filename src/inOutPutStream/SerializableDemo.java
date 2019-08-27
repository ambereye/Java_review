package inOutPutStream;

import java.io.*;

/**
 * TODO
 *  序列化与反序列化
 * @author ambereye
 * @date 2019/8/26
 */
public class SerializableDemo {
    private static final File SAVE_FILE = new File("D:" + File.separator + "Hello.text");
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //saveObject(new Person("张召忠",15));
        System.out.println(loadObject());
    }
    public static void saveObject(Object obj) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
        oos.writeObject(obj); // 序列化
        oos.close();
    }
    public static Object loadObject() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE));
        Object obj = ois.readObject(); // 反序列化
        ois.close();
        return obj;
    }
}

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}