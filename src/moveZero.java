public class moveZero {
    static void moveZeroes(int[] nums) {
        int n=nums.length;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }

    static void swap(int[] nums,int start,int end){
        int temp = nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
    }
    public static void main(String[] args) {
        int[] arr={1,2,0,0,12};
        moveZeroes(arr);
    }
}
