package 二叉树;


import java.util.Arrays;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/8/18
 */
public class JavaDemo {

    public static void main(String[] args) {
        BinaryTree<Person> tree = new BinaryTree<Person>();
        tree.add(new Person("小强-80",80));
        tree.add(new Person("小王-50",50));
        tree.add(new Person("小八-60",60));
        tree.add(new Person("小八-30",30));
        tree.add(new Person("小八-90",90));
        tree.add(new Person("小八-10",10));
        tree.add(new Person("小八-55",55));
        tree.add(new Person("小八-70",70));
        tree.add(new Person("小八-85",85));
        tree.add(new Person("小八-95",95));
        tree.remove(new Person("小八-80",80));
        System.out.println(Arrays.toString(tree.toArrary()));
    }

}

class BinaryTree<T extends Comparable<T>> {
    private class Node {
        private Comparable<T> data;
        private Node parent;
        private Node left;
        private Node right;

        public Node(Comparable<T> data) {
            this.data = data;
        }

        /**
         * 实现节点数据的适当位置的存储
         *
         * @param
         */
        public void addNode(Node newNode) {
            if (newNode.data.compareTo((T) this.data) <= 0) {
                if (this.left == null) { // 现在没有左子树
                    this.left = newNode; // 保存左子树
                    newNode.parent = this; // 保存父节点
                } else { // 需要将左边继续判断
                    this.left.addNode(newNode);
                }

            } else { // 比跟节点还要大
                if (this.right == null) {
                    this.right = newNode;//没有右子树
                    newNode.parent = this;//保存父节点
                } else {
                    this.right.addNode(newNode);//继续向下判断
                }
            }
        }

        public void toArraryNode() {
            if (this.left != null) {// 没有左子树
                this.left.toArraryNode();//递归调用
            }
            BinaryTree.this.returnData[BinaryTree.this.foot++] = this.data;
            if (this.right != null) {
                this.right.toArraryNode();//递归调用
            }
        }

        /**
         * 获取要删除的节点对象
         */
        public Node getRemoveNode(Comparable<T> data) {
            if (data.compareTo((T) this.data) == 0) {
                return this;
            } else if(data.compareTo((T) this.data) < 0){
                if (this.left != null) { // 现在没有左子树
                    return this.left.getRemoveNode(data);
                } else { // 需要将左边继续判断
                    return null;
                }
            }else{
                if (this.right != null) {
                    return this.right.getRemoveNode(data);
                } else {
                    return null;
                }
            }
        }
    }
        // 二叉树实现
        private Node root; // 保存的是根节点
        private int count; // 保存的数据的个数
        private Object[] returnData; // 返回的数据
        private int foot = 0; // 脚标控制

        /**
         * 进行数据保存
         *
         * @param data
         */
        public void add(Comparable<T> data) {
            if (data == null) {
                throw new NullPointerException("保存数据不允许为空");
            }
            // 所有数据本身不具备有节点关系的匹配,那么一定要将其包装在Node类之中
            Node newNode = new Node(data); // 保存节点
            if (this.root == null) {
                this.root = newNode;
            } else {
                this.root.addNode(newNode); // 交由Node类处理
            }
            this.count++;
        }

        /**
         * 以对象数组的形式返回全部数据,没有数据返回null
         */
        public Object[] toArrary() {
            if (this.count == 0) {
                return null;
            }
            this.returnData = new Object[this.count]; //保存长度为数据长度
            this.foot = 0;// 脚标清零
            this.root.toArraryNode();   //直接通过Node类负责
            return this.returnData;// 返回全部数据
        }


        /**
         * 执行数据删除处理
         */
        public void remove(Comparable<T> data){
            if(this.root==null){
                return;//结束调用
            }else{
                if(this.root.data.compareTo((T) data) == 0){ // 要删除的是根节点
                    Node moveNode = this.root.right; // 移动的节点
                    while(moveNode.left != null){//现在还有左边的节点
                        moveNode = moveNode.left;//一直向左找
                    }
                    moveNode.left = this.root.left;
                    moveNode.right = this.root.right;
                    moveNode.parent.left = null;
                    this.root = moveNode;//改变根节点
                }else{
                    Node removeNode = this.root.getRemoveNode(data); // 知道要删除的节点
                    if(removeNode != null){//找到要删除的对象信息
                        // 情况一 : 没有任何的子节点
                        if(removeNode.left==null&&removeNode.right==null){
                            removeNode.left = null;
                            removeNode.right = null;
                            removeNode.parent = null; //父节点直接断开
                        } else if(removeNode.left!=null&&removeNode.right==null){ //左边不为空
                            removeNode.parent.left = removeNode.left;
                            removeNode.left.parent = removeNode.parent;
                        } else if(removeNode.left==null&&removeNode.right!=null){ //右边不为空
                            removeNode.parent.left = removeNode.right;
                            removeNode.right.parent = removeNode.parent;
                        }else{//两边都有节点,则将右边节点中最左边的节点找到,改变其引用
                            Node moveNode = removeNode.right; // 移动的节点
                            while(moveNode.left != null){//现在还有左边的节点
                                moveNode = moveNode.left;//一直向左找
                            }
                            removeNode.parent.left = moveNode;
                            moveNode.parent.left = null;//断开原本的连接
                            moveNode.parent = removeNode.parent;
                            moveNode.right = removeNode.right;//改变原始右节点的指向
                            moveNode.left = removeNode.left;
                        }
                    }
                }
                this.count--;
            }

        }
}
//}
