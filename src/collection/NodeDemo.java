package collection;

/**
 * TODO
 * 链表
 *
 * @author ambereye
 * @date 2019/7/10
 */
public class NodeDemo<E> implements ILink   {
    private class Node {
        private E data;
        private Node next;
        private Node(E data) {
            this.data = data;
        }

        //第一次调用 this.root
        //第一次调用 this.root.next
        //第一次调用 this.root.next.next
        public void addNode(Node newNode){
            if(this.next == null){
                this.next = newNode;
            } else{
                this.next.addNode(newNode);
            }
        }
        // 定义成员
        private Node root;
        //定义方法
        public void add (E e){
            if(e==null){
                return;
            }
            // 数据本身不具备关联特性的，只有Node类有，那么要想实现关联处理，将数据包装在Node类里面处理
            Node newNode = new Node(e);
            if(this.root ==null){//无根节点
                this.root = newNode;//第一个节点作为根节点
            } else { //根节点存在
                this.root.next =newNode;
            }

        }
    }

}
