import java.util.ArrayList;

public class FindtheWinneroftheCircularGame {
    static int findTheWinner(int n, int k) {
        int i=0,c=0;
        int[] arr=new int[n+1];
        for(int j=1;j<=n;j++){
            arr[j]=j;
        }

        int[] result=new int[n];
        int t=0;
        while(c<n){
            i=i+k;
            if(i>n){
                i=0;
            }
            while(arr[i]==0){
                i++;
            }
            if(c<n) {
                result[t++] = arr[i];
                c++;
            }
            arr[i]=0;

        }
        return result[n-1];
    }
    public static void main(String[] args) {
        int ans=findTheWinner(5,2);
        System.out.println(ans);
    }
}
