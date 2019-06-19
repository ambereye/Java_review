package lambda;

import dto.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ambereye
 * @desc 行为参数化实现
 * @data 2019/6/19 20:36
 */
public class Filter {

    /**
     * 通过传入的实际数据进行筛选（颜色、重量）
      */
    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor()) && apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    private List<Apple> inventory;
    /**
     * 下面使用匿名类优化
     */
    List<Apple> greenApples = filterApples(inventory, new ApplePredicate() {
        @Override
        public boolean test(Apple apple) {
            return apple.getColor().equals("green");
        }
    });
    //代码主体
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 使用lambda优化匿名内部类
     */
    List<Apple> greenApples1 = filterApples(inventory, (Apple apple) -> apple.getColor().equals("green"));

    /**
     * 继续优化
     */
    List<Apple> greenApples2 = filterApples(inventory, apple -> apple.getColor().equals("green"));
}
