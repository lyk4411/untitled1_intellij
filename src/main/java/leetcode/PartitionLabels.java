package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2018-4-21.
 * Package name: leetcode
 * Porject name: untitled1
 */
//     这道题给了我们一个字符串S，然我们将其尽可能多的分割为子字符串，
//     条件是每种字符最多只能出现在一个子串中。比如题目汇总的例子，
//     字符串S中有多个a，这些a必须只能在第一个子串中，再比如所有的字
//     母e值出现在了第二个子串中。那么这道题的难点就是如何找到字符串
//     的断点，即拆分成为子串的位置。我们仔细观察题目中的例子，可以
//     发现一旦某个字母多次出现了，那么其最后一个出现位置必须要在当
//     前子串中，字母a，e，和j，分别是三个子串中的结束字母。所以我们
//     关注的是每个字母最后的出现位置，我们可以使用一个HashMap来建立
//     字母和其最后出现位置之间的映射，那么对于题目中的例子来说，我
//     们可以得到如下映射：
//
//        a -> 8
//        b -> 5
//        c -> 7
//        d -> 14
//        e -> 15
//        f -> 11
//        g -> 13
//        h -> 19
//        i -> 22
//        j -> 23
//        k -> 20
//        l -> 21
//
//        建立好映射之后，就需要开始遍历字符串S了，我们维护
//        一个start变量，是当前子串的起始位置，还有一个last变量
//        ，是当前子串的结束位置，每当我们遍历到一个字母，我们
//        需要在HashMap中提取出其最后一个位置，因为一旦当前子串
//        包含了一个字母，其必须包含所有的相同字母，所以我们要
//        不停的用当前字母的最后一个位置来更新last变量，只有当
//        i和last相同了，即当i = 8时，当前子串包含了所有已出现
//        过的字母的最后一个位置，即之后的字符串里不会有之前出
//        现过的字母了，此时就应该是断开的位置，我们将长度9加入
//        结果res中，同理类推，我们可以找出之后的断开的位置，参
//        见代码如下：
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PartitionLabels pl =  new PartitionLabels();
        String s1 = new String("ababcbacadefegdehijhklij");
        System.out.println(pl.partitionLabels(s1));
    }
}
