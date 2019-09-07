package stream;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/7
 */
public class JavaDemo {
    public static void main(String[] args) {
        //Stream进行分析处理
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("语文书",9.9,200));
        orders.add(new Order("数学书",20,110));
        orders.add(new Order("英语书",13,150));
        orders.add(new Order("笔记本",5000,10));
        DoubleSummaryStatistics stat = orders.stream().filter((ele) -> ele.getName().contains("书")).mapToDouble((orderObject) -> orderObject.getPrice() * orderObject.getAmount()).summaryStatistics();
        System.out.println("数量"+stat.getCount());
        System.out.println("总价"+stat.getSum());
        System.out.println("平均"+stat.getAverage());
        System.out.println("最大"+stat.getMax());
    }

}

class Order{
    private String name;
    private double price;
    private int amount;

    public Order(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}