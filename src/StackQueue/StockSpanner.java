package StackQueue;

import java.util.Stack;

public class StockSpanner {

    Stack<int[]> st;

    public StockSpanner() {
        st=new Stack<>();
    }

    public int next(int price) {
        int count=1;
        while(!st.isEmpty() && st.peek()[0]<=price){
            count+=st.pop()[1];
        }
        st.push(new int[]{price,count});

        return count;
    }

    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
}


