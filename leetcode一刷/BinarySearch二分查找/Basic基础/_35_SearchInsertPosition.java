package BinarySearch二分查找.Basic基础;
/**
 * Package Name : BinarySearch二分查找.基础;
 * File name : _35_SearchInsertPosition;
 * Creator: Kane;
 * Date: 8/12/20
 */

/**
 * Time complexity:O(logn);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1; ;
        while (l <= r) {
            int pos = (r - l) / 2 + l;
            if (nums[pos] > target) r = pos - 1;
            else if (nums[pos] < target) l = pos + 1;
            else return pos;
        }
        return l;
    }
}
