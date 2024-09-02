public class xorTriplet {
    static int countTriplets(int[] arr) {
        int n= arr.length;
        int count=0;
        for(int i=0;i<n;i++){
            int val=arr[i];
            for(int j=i+1;j<n;j++){
                val^=arr[j];
                if(val == 0) count+=(j-i);
            }
        }
            return count;
    }
    public static void main(String[] args) {
        int[] arr={2,3,1,6,7};
        int ans=countTriplets(arr);
        System.out.println(ans);
    }
}
