package designPatterns;

/**
 * TODO
 * 多例设计模式
 * @author ambereye
 * @date 2019/7/1
 */
public class MultipleDesign {
    private static final MultipleDesign RED = new MultipleDesign("红色");
    private static final MultipleDesign GREEN = new MultipleDesign("绿色");
    private static final MultipleDesign BLUE = new MultipleDesign("绿色");
    private String title;
    private MultipleDesign (String title){
        this.title = title;
    }
    public static MultipleDesign getInstance(String color){
        switch(color){
            case "red": return RED;
            case "green": return GREEN;
            case "blue": return BLUE;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return this.title;
    }
}
