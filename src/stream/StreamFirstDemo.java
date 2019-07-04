package stream;

/**
 * 初步了解Stream流的概念 解决集合处理时的套路和晦涩，以及难以利用多核
 * 可以根据标准筛选数据、提取数据、给数据分组等。
 * collection主要为了存储和访问数据，而stream则主要用描述对数据的计算
 */
public class StreamFirstDemo {
    //传统写法 从一个列表中筛选金额较高的交易
    /**
     *     Map<Currency, List<Transaction>> transactionsByCurrencies =
     *             new HashMap<>();// 建立累积交易分组的Map
     *     for (Transaction transaction : transactions) {// 遍历交易的List
     *         if(transaction.getPrice() > 1000){// 筛选金额较高的交易
     *             Currency currency = transaction.getCurrency();//提取交易货币
     *             List<Transaction> transactionsForCurrency =
     *                     transactionsByCurrencies.get(currency);
     *             if (transactionsForCurrency == null) { //如果这个货币的分组Map是空的，那就建立一个
     *                 transactionsForCurrency = new ArrayList<>();
     *                 transactionsByCurrencies.put(currency,
     *                         transactionsForCurrency);
     *             }
     *             transactionsForCurrency.add(transaction);//将当前遍历的交易添加到具有同一货币的交易List中
     *         }
     *     }
     */
    //Stream 写法
    /**
     * Map()<Currency,List<Transaction>> transactionByCurrencies =
     *       transactions.stream()
     *                   .filter((Transaction t) -> t.getPrice() >1000)  // 筛选金额较高的交易
     *                   .collect(groupingBy(Transaction::getCurrency)); // 按货币分组
     */

    //Stream 写法 将之前lambda筛选方式转成stream筛选再转回list
    /**
     * List<Apple> heavyApples =
     *      inventory.stream().filter((Apple a) -> a.getWeight()>150)
     *                        .collection(toList());
     */

}
