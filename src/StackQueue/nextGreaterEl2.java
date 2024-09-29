package StackQueue;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterEl2 {
    public static int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
            }
            if(i<n) ans[i] = st.isEmpty() ? -1 : st.peek();

            st.push(nums[i%n]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
    }
}
