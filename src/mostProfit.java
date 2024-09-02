import java.util.Arrays;

public class mostProfit {
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
//        int j=0,i=0,sum=0;
//        while(j<worker.length && i<profit.length){
//            if(worker[j]==difficulty[i]){
//                sum+=profit[i];
//                i++;
//                j++;
//            }
//            else if(worker[j]>difficulty[i]) i++;
//            else{
//                i--;
//                if(worker[j]>difficulty[i] && worker[j]<difficulty[i+1]){
//                    sum+=profit[i];
//                    i++;
//                    j++;
//                }
//            }
//        }
//        return sum;
        int sum=0;
        int[][] jobs = new int[profit.length][2];
        for(int i=0;i<profit.length;i++){
            jobs[i][0]=difficulty[i];
            jobs[i][1]=profit[i];
        }

        Arrays.sort(jobs,(a, b) -> b[1] - a[1]);
        Arrays.sort(worker);

        int a=0,b=worker.length-1;

        for(int i=0;i<jobs.length;i++){
            int diff=jobs[i][0];

            while(b>=0 && worker[b]>=diff){
                sum+=jobs[i][1];
                b--;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr1={2,4,6,8,10};
        int[] arr2={10,20,30,40,50};
        int[] arr3={4,5,6,7};
        int ans=maxProfitAssignment(arr1,arr2,arr3);
        System.out.println(ans);
    }
}
