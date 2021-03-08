/**
 * Date: 3/8/21
 * Question Description:
 * <p>
 * Examples:
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _65_ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean numberAfterE = true;
        boolean eSeen = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) return false;
                pointSeen = true;
            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if (eSeen ||!numberSeen) return false;
                eSeen = true;
                numberAfterE = false;
            }else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && (s.charAt(i - 1) != 'e')) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberSeen && numberAfterE;
    }
}
