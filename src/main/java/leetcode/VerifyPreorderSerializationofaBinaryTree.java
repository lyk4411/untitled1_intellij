package leetcode;

/**
 * Created by lyk on 2017/4/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class VerifyPreorderSerializationofaBinaryTree {
    public static void main(String[] args) {
        VerifyPreorderSerializationofaBinaryTree vpsbt =
                new VerifyPreorderSerializationofaBinaryTree();
        System.out.println(vpsbt.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(vpsbt.isValidSerialization("9,#,#"));
        System.out.println(vpsbt.isValidSerialization("9,#,#,1"));
    }
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node: nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}
