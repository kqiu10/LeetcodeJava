package SlidingWindow;
/**
 * Package Name : SlidingWindow;
 * File name : _565_ArrayNesting;
 * Creator: Kane;
 * Date: 9/3/20
 */

/**
 * A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the
 * longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule
 * below.
 *
 * Suppose the first element in S starts with the selection of element A[i] of index = i, the
 * next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding
 * right before a duplicate element occurs in S.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [5,4,0,3,1,6,2]
 * Output: 4
 * Explanation:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 *
 * One of the longest S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 *
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _565_ArrayNesting {
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int next = i;
            int count = 0;
            while (nums[next] != -1) {
                count++;
                int temp = next;
                next = nums[next];
                nums[temp] = -1;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
