package StackQueue;
public class stackCustom {
    protected int[] data;
    private static final int DEFAULT_SIZE=10;

    int ptr=-1;

    public stackCustom(){
        this(DEFAULT_SIZE);
    }
    public stackCustom(int size){
        this.data=new int[size];
    }

    public int pop() throws stackException{
        if(isEmpty()){
            throw new stackException("Cannot pop from empty stack");
        }
        int removed = data[ptr];
        ptr--;
        return removed;
    }

    public int peek() throws stackException{
        if(isEmpty()){
            throw new stackException("cannot peek from empty stack");
        }
        return data[ptr];
    }
    public boolean push(int item){
        if(isFull()){
            System.out.println("stack is full");
            return false;
        }
        ptr++;
        data[ptr]=item;
        return true;
    }
    public boolean isFull(){
        return ptr==data.length-1;
    }
    public boolean isEmpty(){
        return ptr==-1;
    }
}
