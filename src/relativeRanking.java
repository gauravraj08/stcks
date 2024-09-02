import java.util.HashMap;
import java.util.Arrays;
public class relativeRanking {
    static String[] findRelativeRank(int[] scores){
        Integer[] index = new Integer[scores.length];
        for(int i=0;i<scores.length;i++){
            index[i]=i;
        }
        Arrays.sort(index, (a,b) -> scores[b] - scores[a]);
        System.out.println(Arrays.toString(index));
        String[] res = new String[scores.length];
        for(int i=0;i< scores.length;i++){
            if(i==0){
                res[index[i]]= "Gold Medal";
            }
            if(i==1){
                res[index[i]]="Silver Medal";
            }
            if(i==2){
                res[index[i]]="Bronze Medal";
            }
            else{
                res[index[i]] = (i+1) + "";
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,2,5,4};
        String[] res=findRelativeRank(arr);
        System.out.println(res);
    }
}
