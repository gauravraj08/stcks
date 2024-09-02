package StackQueue;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        CircularQueue qu=new CircularQueue();

        qu.insert(16);
        qu.insert(26);
        qu.insert(36);
        qu.insert(46);
        qu.insert(56);

        qu.display();
        System.out.println(qu.pop());
        qu.display();;
        qu.insert(53);
        qu.display();
    }
}
