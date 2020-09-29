package BinarySearch二分查找.Rotate旋转;
/**
 * Package Name : BinarySearch二分查找.Rotate旋转;
 * File name : FindMinimuminRoatedSortedArrayII154;
 * Creator: Kane;
 * Date: 8/15/20
 */

/**
 * Time complexity:O(logn);
 * Space complexity: O(1);
 * Description: edge case
 * 1 1 1 1 2 1
 */
public class _154_FindMinimuminRoatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int pivot = (r - l) / 2 + l;
            if (nums[l] == nums[pivot] && nums[pivot] == nums[r]){
                l++;
                r--;
            }
            if (nums[pivot] > nums[r]) l = pivot + 1;
            else if (nums[pivot] < nums[r]) r = pivot;
            else r--;

        }
        if (nums[l] < nums[r]) return nums[l];
        else return nums[r];

    }
}
