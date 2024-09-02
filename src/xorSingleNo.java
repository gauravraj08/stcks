import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class xorSingleNo {
    static int[] singleNumber(int[] nums) {
          int[] result = new int[2];
//        HashMap<Integer,Integer> map=new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            map.put(nums[i], map.get(nums[i])!=null ? map.get(nums[i])+1 : 1);
//        }
//        int k=0;
//        for(Map.Entry<Integer,Integer> e: map.entrySet()){
//            if(e.getValue()==1) result[k++]=e.getKey();
//        }
        int ans=0;
        for(int num : nums){
            ans^=num;
        }
        ans &= -ans;
        for(int n:nums){
            if((ans & n)==0) result[0]^=n;
            else result[1]^=n;
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr={1,2,1,3,2,5};
        int[] ans=singleNumber(arr);
        System.out.println(Arrays.toString(ans));
    }
}
