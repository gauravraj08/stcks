import java.util.Arrays;

public class rearrangeElement {
    static int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] ans1=new int[n/2];
        int[] ans2=new int[n/2];
        int k=0,j=0;
        for(int i=0;i<n;i++){
            if(nums[i]<0) ans1[k++]=nums[i];
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0) ans2[j++]=nums[i];
        }
        int[] ans=new int[nums.length];
        ans[0]=ans2[0];
        int m=0,t=1;
        for(int i=1;i<nums.length;i++){
            if(i%2!=0){
                ans[i]=ans1[m++];
            }
            else{
                ans[i]=ans2[t++];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={3,1,-2,-5,2,-4};
        int[] ans=rearrangeArray(arr);
        System.out.println(Arrays.toString(ans));
    }
}
