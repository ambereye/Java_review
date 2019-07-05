package collection;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 * 集合Set去重机制
 * @author ambereye
 * @date 2019/6/25
 */
public class SetDemo {



    public static void main(String[] args) {
        Set<String> stringSet=new HashSet<>();
        /**
         * 这里的add实际上调用了HashSet的add方法 这里是将set的值当成key传入
         * 而hashset的add又调用了HashMap的put方法（put方法：putVal(hash(key), key, value, false, true)）
         * HashMap根据key算hash值，放入存储（Node节点存储？）,key值相同，算出的hash值也相同。
         * 实际上是利用hashMap的key去重的。（啊啊啊啊，还要继续看源码啊）
         */
        stringSet.add("1");
        stringSet.add("1");
        stringSet.add("2");
        //结果为 1 2
        for(String string :stringSet){
            System.out.println(string);
        }

        /**
         * 上面对于八大基础类型去重没有问题
         * 当涉及到实体对象时，传入的值不是值传递了，是引用传递了
         * 往常的去重会导致可能实体的各值相同却无法去重（不同的对象地址不相同-即地址值不相同）
         * 想正常使用需要重写对象的实现，重写equals和hashCode方法！（UserSet）
         */
        UserSet userSet1 = new UserSet(1,"小张");
        UserSet userSet2 = new UserSet(2,"小张");
        UserSet userSet3 = new UserSet(3,"小王");
        UserSet userSet4 = new UserSet(1,"小张");

        Set<UserSet> userSets = new HashSet<UserSet>();
        userSets.add(userSet1);
        userSets.add(userSet2);
        userSets.add(userSet3);
        userSets.add(userSet4);

        // 输入结果 id=2 username=小张 id=3 username=小王 id=1 username=小张
        for (UserSet u : userSets) {
            System.out.println("id=" + u.getId() + " " + "username=" + u.getUsername());
        }

    }


    /**    hashMap的putVal
     *     final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
     *                    boolean evict) {
     *         Node<K,V>[] tab; Node<K,V> p; int n, i;
     *         if ((tab = table) == null || (n = tab.length) == 0)
     *             n = (tab = resize()).length;
     *         if ((p = tab[i = (n - 1) & hash]) == null)
     *             tab[i] = newNode(hash, key, value, null);
     *         else {
     *             Node<K,V> e; K k;
     *             if (p.hash == hash &&
     *                 ((k = p.key) == key || (key != null && key.equals(k))))
     *                 e = p;
     *             else if (p instanceof TreeNode)
     *                 e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
     *             else {
     *                 for (int binCount = 0; ; ++binCount) {
     *                     if ((e = p.next) == null) {
     *                         p.next = newNode(hash, key, value, null);
     *                         if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
     *                             treeifyBin(tab, hash);
     *                         break;
     *                     }
     *                     if (e.hash == hash &&
     *                         ((k = e.key) == key || (key != null && key.equals(k))))
     *                         break;
     *                     p = e;
     *                 }
     *             }
     *             if (e != null) { // existing mapping for key
     *                 V oldValue = e.value;
     *                 if (!onlyIfAbsent || oldValue == null)
     *                     e.value = value;
     *                 afterNodeAccess(e);
     *                 return oldValue;
     *             }
     *         }
     *         ++modCount;
     *         if (++size > threshold)
     *             resize();
     *         afterNodeInsertion(evict);
     *         return null;
     *     }
     */
}
