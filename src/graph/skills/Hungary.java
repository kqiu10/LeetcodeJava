package src.graph.skills;
/**
 * Date: 9/27/20
 * Question Description
 */

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * Description: TODO
 * Time complexity:O(V * E);
 * Space complexity: O();

 */
public class Hungary {

    int[] person;
    int[] places;

    public void match(int[][] matrix) {
        person = new int[4];
        places = new int[3];
        Arrays.fill(person, -1);
        Arrays.fill(places, -1);

        boolean[] visited;
        int res = 0;
        for (int i = 0; i < person.length; i++) {
            visited = new boolean[places.length];
            if (hungary(matrix, i , visited)) {
                res++;
            }
        }
        System.out.println("res : " + res);
        System.out.println(Arrays.toString(person));
        System.out.println(Arrays.toString(places));
    }

    public boolean hungary(int[][] matrix, int start, boolean[] visited) {
        for (int end = 0; end < places.length; end++) {
            //没有边 / 已经访问过
            if (matrix[start][end + 4] == 0 || visited[end]) {
                continue;
            }
            visited[end] = true;
            //1.没有占用 2.是否可以让位置
            if (places[end] == -1 || hungary(matrix, places[end], visited)) {
                person[start] = end;
                places[end] = start;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
        {0, 0, 0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0, 1, 1},
        {0, 0, 0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 0},
        {1, 1, 1, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0},
        };
        Hungary hungary = new Hungary();
        hungary.match(matrix);

    }
}
