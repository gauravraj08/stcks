package StackQueue;

import java.util.Stack;

public class removeKdigit {
    public static String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<num.length();i++){
            char c = num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek()>c){
                st.pop();
                k--;
            }
            st.push(c);
        }
        while(k>0){
            st.pop();
            k--;
        }
        for(int i=0;i<st.size();i++){
            char c = st.get(i);
            if(ans.length()==0 && c=='0'){
                continue;
            }
            ans.append(c);
        }
        return ans.length() == 0 ? "0":ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219",3));
    }

}
