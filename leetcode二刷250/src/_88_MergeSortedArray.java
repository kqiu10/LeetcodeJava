/**
 * Date: 3/14/21
 * Question Description:
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume
 * that nums1 has a size equal to m + n such that it has enough space to hold additional elements
 * from nums2.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int e1 = m - 1;
        int e2 = n - 1;
        int end = m + n - 1;
        while (e1 >= 0 || e2 >= 0) {
            while (e1 >= 0 && e2 >= 0) {
                nums1[end--] = nums1[e1] > nums2[e2] ? nums1[e1--] : nums2[e2--];
            }
            if (e1 >= 0) {
                nums1[end--] = nums1[e1--];
            }
            if (e2 >= 0) {
                nums1[end--] = nums2[e2--];
            }
        }
        return;
    }

}
