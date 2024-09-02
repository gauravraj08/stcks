import java.util.Arrays;

public class magnetic {
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int minForce=1;
        int maxForce=position[position.length-1]-position[0];
        int result=0;
        while(minForce<=maxForce){
            int mid=(minForce+maxForce)/2;
            if(possible(mid,position,m)){
                result=mid;
                minForce=mid + 1;
            }
            else maxForce = mid - 1;
        }
        return result;
    }
    private static boolean possible(int mid,int[] position,int m){
        int prev=position[0];
        int count=1;
        for(int i=1;i<position.length;i++){
            int curr=position[i];
            if(curr-prev>=mid){
                count++;
                prev=curr;
            }
            if(count==m) break;
        }
        return count==m;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,7};
        int ans = maxDistance(arr,3);
        System.out.println(ans);
    }
}
