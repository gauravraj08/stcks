import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {
    static int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(i);
        }
        int[] result=new int[n];
        for(int i=0;i<n;i++) {
            if(!q.isEmpty()){
                int idx=q.remove();
                result[idx]=deck[i];
                if(q.peek()!=null){
                    int k=q.remove();
                    q.add(k);
                }
            }
        }
        return result;
        //System.out.println(q);
    }
    public static void main(String[] args) {
        int[] arr={17,13,11,2,3,5,7};
        int[] ans=deckRevealedIncreasing(arr);
        System.out.println(Arrays.toString(ans));
    }
}
