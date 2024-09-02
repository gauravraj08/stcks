import java.util.Arrays;

public class minMovesToUni {
    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        int next=nums[0]+1;
        for(int i=1;i<nums.length;i++){
            if(next>=nums[i]) ans += (next++ - nums[i]);
            else next = nums[i]+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={3,2,1,2,1,7};
        int ans=minIncrementForUnique(arr);
        System.out.println(ans);
    }
}
