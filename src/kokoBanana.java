public class kokoBanana {
        public static int findMax(int[] v) {
            int maxi = Integer.MIN_VALUE;;
            int n = v.length;
            //find the maximum:
            for (int i = 0; i < n; i++) {
                maxi = Math.max(maxi, v[i]);
            }
            return maxi;
        }

        public static int calculateTotalHours(int[] v, int hourly) {
            int totalH = 0;
            int n = v.length;
            //find total hours:
            for (int i = 0; i < n; i++) {
                totalH += Math.ceil((double)(v[i]) / (double)(hourly));
            }
            return totalH;
        }

        public static int minimumRateToEatBananas(int[] piles, int h) {

            int high=findMax(piles);
            int low=1;
            while(low<=high){
                int mid=(low+high)/2;
                int totalH=calculateTotalHours(piles,mid);
                if(totalH <= h) high = mid-1;
                else low = mid + 1;
            }
            return low;
//            //Find the maximum number:
//            int maxi = findMax(v);
//
//            //Find the minimum value of k:
//            for (int i = 1; i <= maxi; i++) {
//                int reqTime = calculateTotalHours(v, i);
//                if (reqTime <= h) {
//                    return i;
//                }
//            }
//
//            //dummy return statement
//            return maxi;
        }

        public static void main(String[] args) {
            int[] v = {3,6,7,11};
            int h = 8;
            int ans = minimumRateToEatBananas(v, h);
            System.out.println("Koko should eat at least " + ans + " bananas/hr.");
        }
    }
