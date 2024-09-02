package StackQueue;

public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE=10;

    protected int end=0;
    protected int front=0;
    private int size=0;

    public CircularQueue(){
        this(DEFAULT_SIZE);
    }
    public CircularQueue(int size){
        this.data=new int[size];
    }
    public boolean isFull(){
        return size==data.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean insert(int item){
        if (isFull()){
            System.out.println("cannot insert,queue is full");
            return false;
        }
        data[end++]=item;
        end=end % data.length;
        size++;
        return true;
    }
    public int pop() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty,cannot remove any item");
        }
        int removed=data[front++];
        front=front % data.length;
        size--;
        return removed;
    }
    public int peek() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[front];
    }
    public void display(){
        for (int i=front;i<end;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }
}
