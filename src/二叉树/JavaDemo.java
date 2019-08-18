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
        tree.add(new Person("小王-30",30));
        tree.add(new Person("小八-50",50));
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


    }
//}
