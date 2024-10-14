package StackQueue;

import java.util.*;

public class slidingWindowMax {
    public static int[] maxSlidingWindow(int[] nums, int k) {
//        Deque<Integer> q=new ArrayDeque<>();
//        List<Integer> res=new ArrayList<>();
//
//        for(int i=0;i<nums.length;i++){
//            while(!q.isEmpty() && nums[q.getLast()] <= nums[i]){
//                q.removeLast();
//            }
//
//            q.addLast(i);
//
//            // remove first element if it's outside the window
//            if(q.getFirst()==i-k){
//                q.removeFirst();
//            }
//
//            // if window has k elements add to results (first k-1 windows have < k elements
//            // because we start from empty window and add 1 element each iteration)
//            if(i>=k-1) res.add(nums[q.peek()]);
//
//        }
//        return res.stream().mapToInt(i->i).toArray();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> queue = new ArrayDeque<Integer>();

        //add elements index from 0 to k, remove all elemetns greater than current eleement
        for(int i = 0; i  < k; i++){
            while(!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]){
                queue.pollLast();
            }

            queue.addLast(i);
        }

        res[index++] = nums[queue.peekFirst()];

        for(int i = k; i < nums.length; i++){
            if(i - k == queue.peekFirst())
            {
                queue.pollFirst();
            }

            while(!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]){
                queue.pollLast();
            }

            queue.addLast(i);
            res[index++] = nums[queue.peekFirst()];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
    }
}
