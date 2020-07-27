package leetcode.Mathmatics数学题;
/**
 * Description: TODO
 * Package Name : leetcode.Mathmatics数学题;
 * File name : MultiplyStrings;
 * Creator: Kane;
 * Date: 7/25/20
 */

/**
 * num1.length() == n;
 * num2.length() == m;
 * Time complexity:O(n * m);
 * Space complexity: O(n + m);
 */
public class MultiplyStrings43 {
    public static String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) {
            return null;
        }
        int[] digits = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = product + digits[p2];
                digits[p1] += sum / 10;
                digits[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            if (!(digit == 0 && sb.length() == 0)) {
                sb.append(digit);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(multiply("123","456"));
    }
}
