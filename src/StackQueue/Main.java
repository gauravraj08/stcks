package StackQueue;

public class Main {
    public static void main(String[] args) throws stackException{
        stackCustom sc = new DynamicStack();
        sc.push(54);
        sc.push(44);
        sc.push(34);
        sc.push(24);
        sc.push(14);
        sc.push(8);

        System.out.println(sc.pop());
        System.out.println(sc.pop());
        System.out.println(sc.pop());
        System.out.println(sc.pop());
        System.out.println(sc.pop());
        System.out.println(sc.pop());
    }
}
