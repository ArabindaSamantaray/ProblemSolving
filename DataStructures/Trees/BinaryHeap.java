/**
 * This class is responsible for creating a binary heap and performing the following operations:
 * a) Creation of binary heap
 * b) Peek the top of binary heap
 * c) Extract min/max of binary heap
 * d) Traversal of binary heap
 *      --- postorder traversal
 *      --- inorder traversal
 *      --- preorder traversal
 *      --- levelorder traversal
 * e) Insert values into a binary heap
 * f) Delete value from a binary heap
 *
 */

public class BinaryHeap {
    int[] heap;
    String typeOfHeap;

    int openIndex=1;

    private void setSize(int value){
        this.heap = new int[value];
    }

    private void setTypeOfHeap(String typeOfHeap){
        this.typeOfHeap = typeOfHeap;
    }

    private void heapifyFromBottomToTop(int index){
        if(index<=1){
            return;
        }
        int parentIndex = Math.floorDiv(index,2);
        if(this.heap[parentIndex]>this.heap[index] && this.typeOfHeap.equalsIgnoreCase("MIN")){
            int tempValue = this.heap[parentIndex];
            this.heap[parentIndex]=this.heap[index];
            this.heap[index]=tempValue;
        }
        if(this.heap[parentIndex]<this.heap[index] && this.typeOfHeap.equalsIgnoreCase("MAX")){
            int tempValue = this.heap[parentIndex];
            this.heap[parentIndex]=this.heap[index];
            this.heap[index]=tempValue;
        }
        heapifyFromBottomToTop(parentIndex);
    }
    private void insert(int value) {
        if(openIndex>=this.heap.length){
            System.out.println("No more values can be added into the heap");
        }else{
            if(openIndex==1){
                this.heap[openIndex]=value;
            }else {
                this.heap[openIndex]=value;
                heapifyFromBottomToTop(openIndex);
            }
            openIndex++;
        }
    }

    private void delete(){
        openIndex--;
        this.heap[1]=this.heap[openIndex];
        heapifyFromTopToBottom(1);
    }
    public void heapifyFromTopToBottom(int index){
        if(2*index>=openIndex){
            return;
        }else{
            if(this.typeOfHeap.equalsIgnoreCase("min")){
                int swapIndex=this.heap[index*2]<this.heap[2*index+1]?index*2:2*index+1;
                if(this.heap[index]>this.heap[swapIndex]){
                    int tmp = this.heap[index];
                    this.heap[index]=this.heap[swapIndex];
                    this.heap[swapIndex]=tmp;
                    heapifyFromTopToBottom(swapIndex);
                }
            }else {
                int swapIndex=this.heap[index*2]>this.heap[2*index+1]?index*2:2*index+1;
                if(this.heap[index]<this.heap[swapIndex]){
                    int tmp = this.heap[index];
                    this.heap[index]=this.heap[swapIndex];
                    this.heap[swapIndex]=tmp;
                    heapifyFromTopToBottom(swapIndex);
                }

            }

        }
    }
    private void levelOrderTraversal() {
        for(int i=1; i<openIndex; i++){
            System.out.print(this.heap[i]+",");
        }
    }

    public static void main(String[] args) {
        int size=10;
        BinaryHeap binaryHeap = new BinaryHeap();
        binaryHeap.setSize(size+1);
        binaryHeap.setTypeOfHeap("MIN");
        binaryHeap.insert(10);
        binaryHeap.insert(2);
        binaryHeap.insert(3);
        binaryHeap.insert(24);
        binaryHeap.insert(52);
        binaryHeap.insert(6);
        binaryHeap.insert(17);
        binaryHeap.insert(0);
        binaryHeap.insert(11);
        binaryHeap.insert(8);

        binaryHeap.levelOrderTraversal();
        System.out.println("====== LEVEL ORDER TRAVERSAL ======");
        binaryHeap.levelOrderTraversal();
        System.out.println();
        binaryHeap.delete();
        System.out.println("====== LEVEL ORDER TRAVERSAL AFTER DELETE ======");
        binaryHeap.levelOrderTraversal();
        binaryHeap.delete();
        System.out.println();
        System.out.println("====== LEVEL ORDER TRAVERSAL AFTER DELETE ======");
        binaryHeap.levelOrderTraversal();
    }



}
