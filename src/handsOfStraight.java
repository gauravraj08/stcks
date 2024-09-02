import java.util.Arrays;

public class handsOfStraight {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0) return false;
        Arrays.sort(hand);
        for(int i=0;i<n;i++){
            if(hand[i]>=0){
                if(!findNext(hand,groupSize,i,n)) return false;
            }
        }
        return true;
    }
    private static boolean findNext(int[] hand,int gs,int i,int n){
        int curr=hand[i]+1;
        hand[i]=-1;
        int count=1;
        i+=1;
        while(i<n && count<gs){
            if(hand[i]==curr){
                curr=hand[i]+1;
                hand[i]=-1;
                count++;
            }
            i++;
        }
        if(count!=gs) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,6,2,3,4,7,8};
        boolean ans=isNStraightHand(arr,3);
        System.out.println(ans);
    }
}
