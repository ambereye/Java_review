package reflection.级联赋值;

/**
 * TODO
 *
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
