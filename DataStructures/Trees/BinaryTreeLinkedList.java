import java.util.ArrayDeque;
import java.util.Queue;

/**
 * This class will showcase how to represent a binary tree as a linked list. The following operations will be performed on the tree:
 * 1) Create a tree
 * 2) Insert a node
 * 3) Delete a node
 * 4) Traverse the tree
 *      - Preorder traversal
 *      - Inorder traversal
 *      - Postorder traversal
 *      - Levelorder traversal
 */
public class BinaryTreeLinkedList {

    class Node{
        int value;

        int height;
        Node leftChild;
        Node rightChild;

        Node(int value){
            this.value=value;
            this.leftChild=null;
            this.rightChild=null;
        }
        public void addLeftChild(Node node){
            this.leftChild=node;
        }

        public Node getLeftChild(){
            return this.leftChild;
        }

        public void addRightChild(Node node){
            this.rightChild=node;
        }

        public Node getRightChild(){
            return this.rightChild;
        }
        public int getValue(){
            return this.value;
        }

        public void addValue(int value) {
            this.value=value;
        }

        public void setLeftChild(Node node) {
            this.leftChild=node;
        }

        public void setRightChild(Node node) {
            this.rightChild=node;
        }
    }

    public Node root=null;


    public void insertNode(Node node){
        if(this.root==null){
            this.root=node;
        }else {
            Queue queue = new ArrayDeque();
            queue.add(this.root);
            while (queue.size()!=0) {
                Node node1 = (Node)queue.remove();
                if (node1.getLeftChild()==null){
                    node1.addLeftChild(node);
                    return;
                } else if (node1.getRightChild()==null) {
                    node1.addRightChild(node);
                    return;
                }else{
                    queue.add(node1.getLeftChild());
                    queue.add(node1.getRightChild());
                }
            }
        }
    }

    public void preOrderTraversal(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.getValue());
        preOrderTraversal(node.getLeftChild());
        preOrderTraversal(node.getRightChild());
    }

    public void inOrderTraversal(Node node){
        if(node==null){
            return;
        }
        inOrderTraversal(node.getLeftChild());
        System.out.print(node.getValue());
        inOrderTraversal(node.getRightChild());
    }

    public void levelOrderTraversal(){
          Queue queue = new ArrayDeque();
          queue.add(this.root);
          while (queue.size()!=0){
              Node node = (Node) queue.remove();
              System.out.print(node.getValue());
              if(node.getLeftChild()!=null){
                  queue.add(node.getLeftChild());
              }
              if(node.getRightChild()!=null){
                  queue.add(node.getRightChild());
              }
          }
    }

    public void postOrderTraversal(Node node){
        if(node==null){
            return;
        }
        postOrderTraversal(node.getLeftChild());
        postOrderTraversal(node.getRightChild());
        System.out.print(node.getValue());
    }

    public void deleteNode(int value){
        Node deepestNode;
        Node toBeSearched;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(this.root);
        while (queue.size()!=0){
            Node node = (Node)queue.remove();
            if(node.getValue() == value){
                toBeSearched = node;
                deepestNode = getDeepestNode();
                toBeSearched.addValue(deepestNode.getValue());
                deleteDeepestNode(deepestNode);
            }else{
                if(node.getRightChild()!=null){
                    queue.add(node.getRightChild());
                }
                if(node.getLeftChild()!=null){
                    queue.add(node.getLeftChild());
                }
            }
        }
    }

    private void deleteDeepestNode(Node deepestNode) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(this.root);
        Node parentNode;
        while (queue.size()!=0){
            parentNode = (Node) queue.remove();
            if(parentNode.getLeftChild()==deepestNode){
                parentNode.setLeftChild(null);
                return;
            } else if (parentNode.getRightChild()==deepestNode) {
                parentNode.setRightChild(null);
                return;
            } else if (parentNode.getLeftChild()!=null){
                queue.add(parentNode.getLeftChild());
            } else if (parentNode.getRightChild()!=null) {
                queue.add(parentNode.getRightChild());
            }
        }
    }

    public Node getDeepestNode(){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(this.root);
        Node currentNode = null;
        while(queue.size()!=0){
            currentNode = (Node) queue.remove();
            if(currentNode.getLeftChild()!=null){
                queue.add(currentNode.getLeftChild());
            }
            if(currentNode.getRightChild()!=null){
                queue.add(currentNode.getRightChild());
            }
        }
        return currentNode;
    }

    public static void main(String args[]){
        BinaryTreeLinkedList bt = new BinaryTreeLinkedList();
        bt.insertNode(bt.new Node(1));
        bt.insertNode(bt.new Node(2));
        bt.insertNode(bt.new Node(3));
        bt.insertNode(bt.new Node(4));
        bt.insertNode(bt.new Node(5));
        bt.insertNode(bt.new Node(6));
        bt.insertNode(bt.new Node(7));
        bt.insertNode(bt.new Node(8));
        bt.insertNode(bt.new Node(9));

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
        bt.deleteNode(3);
        System.out.println("====== TREE AFTER NODE DELETION ======");
        bt.levelOrderTraversal();
        System.out.println();
        bt.deleteNode(4);
        System.out.println("====== TREE AFTER NODE DELETION ======");
        bt.levelOrderTraversal();
    }
}
