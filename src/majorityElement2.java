import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class majorityElement2 {
    static List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 3)
                ans.add(key);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,2};
        List<Integer> ans = majorityElement(arr);
        System.out.println(ans);
    }
}
