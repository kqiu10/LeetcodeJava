package leetcode.Heap堆.PriorityQueue;
/**
 * Date: 9/24/20
 * Question Description
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same
 * frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 */

import java.util.*;

/**
 * Description: TODO
 * Time complexity:O(nlogk);
 * Space complexity: O(k);

 */
public class _692_TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<String>((a ,b) -> map.get(a).equals(map.get(b))
                ? b.compareTo(a): map.get(a) - map.get(b));

        for (String word : map.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
