package leetcode;

/**
 * Created by lyk on 2017/6/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FriendCircles {
    public static void main(String[] args) {
        FriendCircles fc = new FriendCircles();
        int[][] matrix = new int[][]{
                {1,1,0,0},
                {1,1,0,0},
                {0,0,1,0},
                {0,0,0,1},
        };
        System.out.println(fc.findCircleNum(matrix));
    }
    //那么比较直接的解法就是DFS搜索，对于某个人，遍历其好友，然后再遍历其好友的好友，
    // 那么我们就能把属于同一个朋友圈的人都遍历一遍，我们同时标记出已经遍历过的人，
    // 然后累积朋友圈的个数，再去对于没有遍历到的人在找其朋友圈的人，这样就能求出个数。
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}
