public class BinarySearchTreeArray {

    /**
     * This class will showcase how to represent a binary search tree as an array. The following operations will be performed on the tree:
     * 1) Create a tree
     * 2) Insert a node
     * 3) Delete a node
     * 4) Traverse the tree
     *      - Preorder traversal
     *      - Inorder traversal
     *      - Postorder traversal
     *      - Levelorder traversal
     */
    Integer[] bst;

    private void insert(int index, int value){
        if(index >= this.getSize()){
            System.out.println("There is no space in the array to store the value "+value);
            return;
        }else{
            if(bst[index]==null){
                bst[index]=value;
            } else if (value<=bst[index]) {
                insert(index*2, value);
            } else{
                insert(index*2+1, value);
            }
        }
    }

    private void levelOrderTraversal(){
        for(int i=1; i<this.getSize(); i++){
            if(bst[i]==null){
                System.out.print("null");
            }else{
                System.out.print(bst[i].intValue());
            }
        }
    }

    private void preOrderTraversal(int index){
        if(index>this.getSize()-1){
            return;
        }
        if(bst[index]==null){
            System.out.print("null");
        }else{
            System.out.print(bst[index].intValue());
        }
        preOrderTraversal(2*index);
        preOrderTraversal(2*index+1);
    }

    private void inOrderTraversal(int index){
        if(index>this.getSize()-1){
            return;
        }
        inOrderTraversal(2*index);
        if(bst[index]==null){
            System.out.print("null");
        }else{
            System.out.print(bst[index].intValue());
        }
        inOrderTraversal(2*index+1);
    }

    private void postOrderTraversal(int index){
        if(index>this.getSize()-1){
            return;
        }
        postOrderTraversal(2*index);
        postOrderTraversal(2*index+1);
        if(bst[index]==null){
            System.out.print("null");
        }else{
            System.out.print(bst[index].intValue());
        }

    }
    private void setSize(int size) {
        this.bst = new Integer[size];
        for(int i=0; i<size; i++){
            this.bst[i]=null;
        }
    }

    private int getSize(){
        return this.bst.length;
    }
    public static void main(String[] args) {
        BinarySearchTreeArray bstArray = new BinarySearchTreeArray();
        int wantedSize=10;
        bstArray.setSize(wantedSize+1);
        bstArray.insert(1, 10);
        bstArray.insert(1, 2);
        bstArray.insert(1,3);
        bstArray.insert(1, 24);
        bstArray.insert(1, 52);
        bstArray.insert(1,6);
        bstArray.insert(1, 17);
        bstArray.insert(1, 0);
        bstArray.insert(1, 11);
        bstArray.insert(1, 8);
        System.out.println("====== PRE ORDER TRAVERSAL ======");
        bstArray.preOrderTraversal(1);
        System.out.println();
        System.out.println("====== IN ORDER TRAVERSAL ======");
        bstArray.inOrderTraversal(1);
        System.out.println();
        System.out.println("====== POST ORDER TRAVERSAL ======");
        bstArray.postOrderTraversal(1);
        System.out.println();
        System.out.println("====== LEVEL ORDER TRAVERSAL ======");
        bstArray.levelOrderTraversal();
        System.out.println();
    }




}
