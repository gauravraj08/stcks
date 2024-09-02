import java.util.Arrays;

public class searchRange {
    static int[] searchRangeI(int[] nums, int target) {
        int[] ans = {-1,-1};

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }

        if (left >= nums.length || nums[left] != target) return ans;

        ans[0] = left;

        right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        ans[1] = right;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={5,7,7,8,8,10};
        int[] ans= searchRangeI(arr,8);
        for (int i=0;i<ans.length;i++){
        System.out.println(ans[i]);
        }
    }
}
