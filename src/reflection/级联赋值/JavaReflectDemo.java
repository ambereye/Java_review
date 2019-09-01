package reflection.级联赋值;

/**
 * TODO
 * 一个简单Java类中的属性类型不仅仅只有String，还会包含有整数、浮点数、日期等，主要讲解如何实现多种数据类型的赋值以及转换处理操作。
 * 一个类可以与其它类发生引用关系，以描述彼此之间的关系，这样的级联结构中就需要考虑对象实例化问题，本课程主要讲解如何在多级VO配置关系时如何通过反射技术实现动态实例化对象操作。
 * 类引用定义之后就会存在有其它引用类型的属性赋值操作，本课程主要讲解多级实例化对象属性内容的获取与其属性设置。
 * @author ambereye
 * @date 2019/9/1
 */
public class JavaReflectDemo {
    public static void main(String[] args) throws Exception{
        String value = "ename:Smith|job:Clerk|salary:8960.00|age:30|hiredate:2003-10-03|"
                +"dept.dname:财务部|dept.company.name:twitter|"
                +"dept.company.createdate:2001-11-11";
        Emp emp = ClassInstanceFactory.create(Emp.class, value);
        System.out.println(emp);
        System.out.println(emp.getDept());
        System.out.println(emp.getDept().getCompany());
    }
}
