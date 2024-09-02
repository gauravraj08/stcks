public class subArrayByK {
    public static int subarraysDivByK(int[] nums, int k) {
        int count=0,sum=0,rem=0,n=nums.length;
        int[] prefix=new int[k];

        for(int i=0;i<n;i++){
            sum+=nums[i];
            rem=sum%k;

            if(rem<0) rem+=k;

            prefix[rem]++;
        }

        for(int i=0;i<k;i++){
            if(prefix[i]>1) count+= (prefix[i] * (prefix[i]-1))/2;
        }
        count += prefix[0];
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,0,-2,-3,1};
        int ans=subarraysDivByK(arr,5);
        System.out.println(ans);
    }
}
