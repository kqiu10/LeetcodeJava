/**
 * Date: 2/25/21
 * Question Description:
 * Given two integers dividend and divisor, divide two integers without using multiplication,
 * division, and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For
 * example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 *
 * Note:
 *
 * Assume we are dealing with an environment that could only store integers within the 32-bit
 * signed integer range: [−231,  231 − 1]. For this problem, assume that your function returns
 * 231 − 1 when the division result overflows.
 * <p>
 * Examples:
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 * Example 3:
 *
 * Input: dividend = 0, divisor = 1
 * Output: 0
 * Example 4:
 *
 * Input: dividend = 1, divisor = 1
 * Output: 1
 */

/**
 * Time Complexity: O(logn)
 * Space Complexity: O(logn)
 */
public class _29_DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        int signal = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            signal = -1;
        }
        long Ldividend = Math.abs((long)dividend);
        long Ldivisor = Math.abs((long)divisor);
        if (Ldividend < Ldivisor || dividend == 0) return 0;

        long Lres = helper(Ldividend, Ldivisor);

        if (Lres >= Integer.MAX_VALUE) {
            return signal == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int)Lres * signal;
    }

    private static long helper(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + helper(ldividend - sum, ldivisor);
    }

    public static void main(String[] args) {
        divide(7, -3);
    }

}