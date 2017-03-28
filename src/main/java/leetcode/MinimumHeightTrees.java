package leetcode;

import java.util.*;

/**
 * Created by lyk on 2017/3/28.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MinimumHeightTrees {
    public static void main(String[] args) {
        MinimumHeightTrees mht = new MinimumHeightTrees();
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {0, 1}, {3, 4}};
        System.out.println(mht.findMinHeightTrees(5, edges));
    }
//    这道题虽然是树的题目，但是跟其最接近的题目是Course Schedule 课程清单
// 和Course Schedule II 课程清单之二。由于LeetCode中的树的题目主要都是针对
// 于二叉树的，而这道题虽说是树但其实本质是想考察图的知识，这道题刚开始在
// 拿到的时候，我最先想到的解法是遍历的点，以每个点都当做根节点，算出高度，
// 然后找出最小的，但是一时半会又写不出程序来，于是上网看看大家的解法，发现
// 大家推崇的方法是一个类似剥洋葱的方法，就是一层一层的褪去叶节点，最后剩下
// 的一个或两个节点就是我们要求的最小高度树的根节点，这种思路非常的巧妙，而
// 且实现起来也不难，跟之前那到课程清单的题一样，我们需要建立一个图g，是一
// 个二维数组，其中g[i]是一个一维数组，保存了i节点可以到达的所有节点。我们
// 开始将所有只有一个连接边的节点(叶节点)都存入到一个队列queue中，然后我们
// 遍历每一个叶节点，通过图来找到和其相连的节点，并且在其相连节点的集合中将
// 该叶节点删去，如果删完后此节点也也变成一个叶节点了，加入队列中，再下一轮
// 删除。那么我们删到什么时候呢，当节点数小于等于2时候停止，此时剩下的一个
// 或两个节点就是我们要求的最小高度树的根节点啦，参见代码如下：
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if (n == 1) return Collections.singletonList(0);
            List<Integer> leaves = new ArrayList<>();
            List<Set<Integer>> adj = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
            for (int[] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }
            for (int i = 0; i < n; ++i) {
                if (adj.get(i).size() == 1) leaves.add(i);
            }

            while (n > 2) {
                n -= leaves.size();
                List<Integer> newLeaves = new ArrayList<>();
                for (int i : leaves) {
                    int t = adj.get(i).iterator().next();
                    adj.get(t).remove(i);
                    if (adj.get(t).size() == 1) newLeaves.add(t);
                }
                //System.out.println(newLeaves);
                leaves = newLeaves;
            }
            return leaves;
        }

}
