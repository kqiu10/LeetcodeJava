package leetcode.Graph图.BFS;
/**
 * Date: 9/22/20
 * Question Description
 * A tree is an undirected graph in which any two vertices are connected by exactly one path. In
 * other words, any connected graph without simple cycles is a tree.
 *
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] =
 * [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the
 * tree, you can choose any node of the tree as the root. When you select a node x as the root,
 * the result tree has height h. Among all possible rooted trees, those with minimum height (i.e.
 * min(h))  are called minimum height trees (MHTs).
 *
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 *
 * The height of a rooted tree is the number of edges on the longest downward path between the
 * root and a leaf.
 *
 * Example 1:
 * Input: n = 4, edges = [[1,0],[1,2],[1,3]]
 * Output: [1]
 * Explanation: As shown, the height of the tree is 1 when the root is the node with label 1
 * which is the only MHT.
 * Example 2:
 * Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * Output: [3,4]
 *
 * Example 3:
 * Input: n = 1, edges = []
 * Output: [0]
 *
 * Example 4:
 * Input: n = 2, edges = [[0,1]]
 * Output: [0,1]
 *
 */

import java.util.*;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _310_MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new LinkedList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<HashSet<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                res.add(i);
            }
        }
        while (n > 2) {
            n -= res.size();
            List<Integer> leaves = new ArrayList<>();
            for (int i : res) {
                for (int j : adj.get(i)) {
                    adj.get(j).remove(i);
                    if (adj.get(j).size() == 1) {
                        leaves.add(j);
                    }
                }
            }
            res = leaves;
        }
        return res;
    }
}
