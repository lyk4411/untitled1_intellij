package headfirst.flyweight;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.flyweight
 * Porject name: untitled1
 */

public class TreeManager {

    int[][] treeArray = {{1,2,10},{1,2,10},{1,2,10}};

    public void displayTree() {
        for (int i = 0; i < treeArray.length; i++) {
            FlyweightTree.display(treeArray[i][0], treeArray[i][1], treeArray[i][2]);
        }
    }

    public static void main(String[] args) {
        TreeManager t = new TreeManager();
        t.displayTree();
    }
}