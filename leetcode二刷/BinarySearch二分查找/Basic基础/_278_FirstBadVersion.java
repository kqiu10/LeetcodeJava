package BinarySearch二分查找.Basic基础;
/**
 * Package Name : BinarySearch二分查找.Basic;
 * File name : _278_FirstBadVersion;
 * Creator: Kane;
 * Date: 8/12/20
 */

/**
 * Time complexity:O(logn);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _278_FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (isBadVersion(mid)) r = mid - 1;
            else l = mid + 1;
        }
        return l;


    }
    //avoid IDE throw error;
    private boolean isBadVersion(int mid) {
        return true;
    }
}
