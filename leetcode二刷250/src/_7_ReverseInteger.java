/**
 * Date: 2/17/21
 * Question Description
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the
 * value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Examples:
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 * Example 4:
 *
 * Input: x = 0
 * Output: 0
 */

/**
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */
public class _7_ReverseInteger {
    public int reverse(int x) {
        int signal = x < 0 ? -1 : 1;
        x = Math.abs(x);
        long reverse = 0;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
            if (reverse >= Integer.MAX_VALUE) {
                return 0;
            }
        }
        return signal * (int)reverse;

    }
}
