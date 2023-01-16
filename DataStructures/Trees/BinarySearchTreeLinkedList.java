import java.util.ArrayDeque;
import java.util.Queue;

/**
 * This class will showcase how to represent a binary search tree as a linked list. The following operations will be performed on the tree:
 * 1) Create a tree
 * 2) Insert a node
 * 3) Delete a node
 * 4) Traverse the tree
 *      - Preorder traversal
 *      - Inorder traversal
 *      - Postorder traversal
 *      - Levelorder traversal
 */
public class BinarySearchTreeLinkedList {
    class Node{
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;
            this.leftChild=null;
            this.rightChild=null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }

    BinarySearchTreeLinkedList.Node root=null;

    public void insert(Node currentNode, Node node){
        if(this.root==null){
            root=node;
        }else{
            if(node.getValue()<=currentNode.getValue()){
                if(currentNode.getLeftChild()!=null){
                    insert(currentNode.getLeftChild(), node);
                }else {
                    currentNode.setLeftChild(node);
                }
            }else{
                if(currentNode.getRightChild()!=null){
                    insert(currentNode.getRightChild(), node);
                }else{
                    currentNode.setRightChild(node);
                }
            }
        }
    }

    public void preOrderTraversal(Node node){
        if(node==null){
            return;
        }else{
            System.out.print(node.getValue()+",");
            preOrderTraversal(node.getLeftChild());
            preOrderTraversal(node.getRightChild());
        }
    }

    public void inOrderTraversal(Node node){
        if(node==null){
            return;
        }else{
            inOrderTraversal(node.getLeftChild());
            System.out.print(node.getValue()+",");
            inOrderTraversal(node.getRightChild());
        }
    }

    public void postOrderTraversal(Node node){
        if(node==null){
            return;
        }else{
            postOrderTraversal(node.getLeftChild());
            postOrderTraversal(node.getRightChild());
            System.out.print(node.getValue()+",");
        }
    }

    public void levelOrderTraversal(){
        Queue queue = new ArrayDeque();
        queue.add(this.root);
        while (queue.size()!=0){
            Node node = (Node) queue.remove();
            System.out.print(node.getValue()+",");
            if(node.getLeftChild()!=null){
                queue.add(node.getLeftChild());
            }
            if(node.getRightChild()!=null){
                queue.add(node.getRightChild());
            }
        }
    }

    public void searchValue(Node node, int value){
        if(value<node.getValue()){
            if(node.getLeftChild()!=null){
                searchValue(node.getLeftChild(), value);
            }else{
                System.out.println("The value "+ value+ " does not exist in the tree");
            }
        } else if (node.getValue()<value) {
            if(node.getRightChild()!=null){
                searchValue(node.getRightChild(), value);
            }else{
                System.out.println("The value "+ value+ " does not exist in the tree");
            }
        }else {
            System.out.println("The value "+ value+ " does exist in the tree");
        }
    }

    public Node findMinimumNode(Node node){
        if(node.getLeftChild()==null){
            return node;
        }else{
            return findMinimumNode(node.getLeftChild());
        }
    }
    public Node deleteValue(Node node, int value){        //<----- Unlike other methods we have to return the node value , so that the parent node can point to the new node
        if(node==null){
            System.out.println("The value does not exist in the tree");
            return null;
        }
        if(value< node.getValue()){
            node.setLeftChild(deleteValue(node.getLeftChild(), value));
        } else if (value> node.getValue()) {
            node.setRightChild(deleteValue(node.getRightChild(), value));
        }else{
            if(node.getRightChild()!=null && node.getLeftChild()!=null){
                Node minNode = findMinimumNode(node.getRightChild());
                node.setValue(minNode.getValue());
                deleteValue(node.getRightChild(), minNode.getValue()); //<--- This is an important step, where you can delete the minimum node
            } else if (node.getRightChild()!=null) {
                node.setValue(node.getRightChild().getValue());
                node.setRightChild(null);
            } else if (node.getLeftChild()!=null) {
                node.setValue(node.getLeftChild().getValue());
                node.setLeftChild(null);
            } else {
              node=null;
            }
        }
        return node;
    }
    public static void main(String[] args) {
        BinarySearchTreeLinkedList bt = new BinarySearchTreeLinkedList();
        bt.insert(bt.root, bt.new Node(70));
        bt.insert(bt.root, bt.new Node(50));
        bt.insert(bt.root, bt.new Node(90));
        bt.insert(bt.root, bt.new Node(30));
        bt.insert(bt.root, bt.new Node(60));
        bt.insert(bt.root, bt.new Node(80));
        bt.insert(bt.root, bt.new Node(100));
        bt.insert(bt.root, bt.new Node(20));
        bt.insert(bt.root, bt.new Node(40));
        bt.insert(bt.root, bt.new Node(85));
        bt.insert(bt.root, bt.new Node(101));
        bt.insert(bt.root, bt.new Node(95));
        bt.insert(bt.root, bt.new Node(96));

        System.out.println("====== PRE ORDER TRAVERSAL ======");
        bt.preOrderTraversal(bt.root);
        System.out.println();
        System.out.println("====== IN ORDER TRAVERSAL ======");
        bt.inOrderTraversal(bt.root);
        System.out.println();
        System.out.println("====== POST ORDER TRAVERSAL ======");
        bt.postOrderTraversal(bt.root);
        System.out.println();
        System.out.println("====== LEVEL ORDER TRAVERSAL ======");
        bt.levelOrderTraversal();
        System.out.println();
        System.out.println("====== SEARCH VALUE ======");
        bt.searchValue(bt.root, 80);
        System.out.println("====== SEARCH VALUE ======");
        bt.searchValue(bt.root, 32);
        System.out.println("====== DELETE VALUE ======");
        bt.deleteValue(bt.root, 40);
        bt.levelOrderTraversal();
        System.out.println();
        System.out.println("====== DELETE VALUE ======");
        bt.deleteValue(bt.root, 30);
        bt.levelOrderTraversal();
        System.out.println();
        System.out.println("====== DELETE VALUE ======");
        bt.deleteValue(bt.root, 90);
        bt.levelOrderTraversal();
    }
}
