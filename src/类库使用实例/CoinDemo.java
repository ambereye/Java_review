package 类库使用实例;

import java.util.Random;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/21
 */
public class CoinDemo {
    public static void main(String[] args) {
        Coin con = new Coin();
        con.throwCoin(1000);
        System.out.println("正面次数:"+con.getFront()+"反面次数:"+con.getBack());
    }

}

class Coin{
    private int front;// 保存正面次数
    private int back;// 保存背面次数
    private Random random = new Random();
    /**
     * 扔硬币处理
     */
    public void throwCoin(int num){
        for (int i = 0; i < num; i++) {
            int temp = random.nextInt(2);
            if(temp == 0){
                this.front++;
            }else{
                this.back++;
            }
        }

    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getBack() {
        return back;
    }

    public void setBack(int back) {
        this.back = back;
    }
}
