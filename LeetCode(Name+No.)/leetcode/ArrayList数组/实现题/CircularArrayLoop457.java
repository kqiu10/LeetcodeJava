package ArrayList数组.实现题;
/**
 * Package Name : 数组.实现题;
 * File name : CircularArrayLoop457;
 * Creator: Kane;
 * Date: 8/11/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description:
 * the method of LinkedList, and two pointer, one step once a time, one step twice a time.
 */
public class CircularArrayLoop457 {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            int slow = i;
            int fast = getIndex(i, nums);
            while (nums[fast] * nums[i] > 0 && nums[getIndex(fast,nums)] * nums[i] > 0) {
                if (slow == fast) {
                    if (slow == getIndex(slow, nums)) break;
                    return true;
                }
                slow = getIndex(slow, nums);
                fast = getIndex(getIndex(fast, nums), nums);
            }
            //get rid of all looped point, turn them to 0
            slow = i;
            int val = nums[i];
            while (nums[slow] * val > 0) {
                int next = getIndex(slow, nums);
                nums[slow] = 0;
                slow = next;
            }
        }
        return false;

    }
    private int getIndex(int i, int[] nums) {
        int len = nums.length;
        //consider negative number
        return ((i + nums[i]) % len + len) % len;
    }
}
