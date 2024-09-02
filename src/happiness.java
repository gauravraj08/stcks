import java.util.Arrays;

public class happiness {
        static long maximumHappinessSum(int[] happiness, int k) {
            Arrays.sort(happiness);
            long res = 0;
            int n = happiness.length, j = 0;

            for (int i = n - 1; i >= n - k; --i) {
                happiness[i] = Math.max(happiness[i] - j++, 0);
                res += happiness[i];
            }

            return res;
        }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1};
        long ans = maximumHappinessSum(arr,4);
        System.out.println(ans);
    }

}
