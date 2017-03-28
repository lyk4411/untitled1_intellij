package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lyk on 2017/3/28.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CloneGraph {
    public static void main(String[] args) {
        CloneGraph cg = new CloneGraph();
        UndirectedGraphNode ugn0 = new UndirectedGraphNode(0);
        UndirectedGraphNode ugn1 = new UndirectedGraphNode(1);
        UndirectedGraphNode ugn2 = new UndirectedGraphNode(2);
        ugn0.neighbors.add(ugn1);
        ugn0.neighbors.add(ugn2);
        ugn1.neighbors.add(ugn2);
        ugn2.neighbors.add(ugn2);
        UndirectedGraphNode ugn = cg.clone(ugn0);
        System.out.println(ugn);

    }
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;

        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

    @Override
    public String toString() {
        return label + "  " + neighbors.size();
    }
}
