package String字符串.实现题;
/**
 * Package Name : String字符串.实现题;
 * File name : _293_FlipGame;
 * Creator: Kane;
 * Date: 9/2/20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only
 * these two characters: + and -, you and your friend take turns to flip two consecutive "++"
 * into "--". The game ends when a person can no longer make a move and therefore the other
 * person will be the winner.
 *
 * Write a function to compute all possible states of the string after one valid move.
 *
 * Example:
 *
 * Input: s = "++++"
 * Output:
 * [
 *   "--++",
 *   "+--+",
 *   "++--"
 * ]
 *
 * Time complexity:O(n^2);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _293_FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 2 || s == null) return res;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                res.add(s.substring(0, i - 1) + "--" + s.substring(i+1, s.length()));
            }
        }
        return res;
    }
}
