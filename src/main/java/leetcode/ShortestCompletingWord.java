package leetcode;

/**
 * Created by lyk on 2018-4-23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String ans = "";
        int minLen = 1111;

        int[] map = new int[32];
        for (char c : licensePlate.toLowerCase().toCharArray())
            if (c >= 'a' && c <= 'z') map[c - 'a'] ++;


        for (String word : words) {
            int len = word.length();
            if (contains(map, word)) {
                if (len < minLen) {
                    ans = word;
                    minLen = len;
                }
            }
        }
        return ans;
    }

    boolean contains(int[] map, String word) {
        int[] map2 = new int[32];
        for (char c : word.toLowerCase().toCharArray()) {
            map2[c - 'a'] ++;
        }

        for (int i = 0; i < 32; ++i) {
            if (map[i] != 0) {
                if (map2[i] < map[i]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ShortestCompletingWord scw = new ShortestCompletingWord();
        String[] words1 = new String[]{
                "step", "steps", "stripe", "stepple"
        };
        String[] words2 = new String[]{
                "looks", "pest", "stew", "show"
        };
        System.out.println(scw.shortestCompletingWord("1s3 PSt",words1));
        System.out.println(scw.shortestCompletingWord("1s3 456",words2));

    }
}
