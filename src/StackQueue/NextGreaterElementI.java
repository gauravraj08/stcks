package StackQueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementI {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;

        int[] ans=new int[n1];
        for(int i=n1-1;i>=0;i--){
            int j=n2-1;
            Stack<Integer> st=new Stack<>();
            while(j>0){
                while(!st.isEmpty() && j>0 && nums1[i]!=nums2[j]){
                    if(nums2[j]>=nums1[i]){
                        st.pop();
                        st.push(nums2[j]);
                    }
                    j--;
                }
                if(st.isEmpty()){
                    ans[i]=-1;
                    st.push(nums2[j]);
                }
                else if(nums1[i]==nums2[j] && nums1[i]<st.peek()){
                    ans[i]=st.pop();
                    break;
                }
                else ans[i]=-1;
                j--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr1={4,1,2};
        int[] arr2={1,3,4,2};
        int[] ans=nextGreaterElement(arr1,arr2);
        System.out.println(Arrays.toString(ans));
    }
}
