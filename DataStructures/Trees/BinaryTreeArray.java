/**
 * This class will showcase how to represent a binary tree as an array. The following operations will be performed on the tree:
 * 1) Create a tree
 * 2) Insert a node
 * 3) Delete a node
 * 4) Traverse the tree
 *      - Preorder traversal
 *      - Inorder traversal
 *      - Postorder traversal
 *      - Levelorder traversal
 */
public class BinaryTreeArray {
    int[] arrayOfValues = new int[10];
    int openIndex = 1;

    private void insertValues(int value) {
        if(openIndex<this.arrayOfValues.length){
            this.arrayOfValues[openIndex]=value;
            openIndex++;
        }else {
            System.out.println("The array is full, so cannot insert new value");
        }
    }

    private void preOrderTraversal(int index){
        if(index>this.openIndex-1){
            return;
        }
        System.out.print(this.arrayOfValues[index]);
        preOrderTraversal(2*index);
        preOrderTraversal(2*index+1);
    }

    private void inOrderTraversal(int index){
        if(index>this.openIndex-1){
            return;
        }
        inOrderTraversal(2*index);
        System.out.print(this.arrayOfValues[index]);
        inOrderTraversal(2*index+1);
    }

    private void postOrderTraversal(int index){
        if(index>this.openIndex-1){
            return;
        }
        postOrderTraversal(2*index);
        postOrderTraversal(2*index+1);
        System.out.print(this.arrayOfValues[index]);
    }

    private void levelOrderTraversal(){
        for (int i=1;i<this.openIndex;i++){
            System.out.print(arrayOfValues[i]);
        }
    }

    private void deleteNode(int value){
        for(int i=1; i<this.arrayOfValues.length; i++){
            if(this.arrayOfValues[i]==value){
                this.arrayOfValues[i] = this.arrayOfValues[this.openIndex-1];
                this.openIndex--;
            }
        }
    }

    public static void main(String args[]){
        BinaryTreeArray bt = new BinaryTreeArray();
        bt.arrayOfValues[0]=0;
        bt.insertValues(1);
        bt.insertValues(2);
        bt.insertValues(3);
        bt.insertValues(4);
        bt.insertValues(5);
        bt.insertValues(6);
        bt.insertValues(7);
        bt.insertValues(8);
        bt.insertValues(9);
        System.out.println("====== PRE ORDER TRAVERSAL ======");
        bt.preOrderTraversal(1);
        System.out.println();
        System.out.println("====== IN ORDER TRAVERSAL ======");
        bt.inOrderTraversal(1);
        System.out.println();
        System.out.println("====== POST ORDER TRAVERSAL ======");
        bt.postOrderTraversal(1);
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
