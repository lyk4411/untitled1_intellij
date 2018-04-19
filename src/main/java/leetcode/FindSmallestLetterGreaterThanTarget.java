package leetcode;

/**
 * Created by lyk on 2018-4-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        boolean[] seen = new boolean[26];
        for (char c: letters)
            seen[c - 'a'] = true;

        while (true) {
            target++;
            if (target > 'z') target = 'a';
            if (seen[target - 'a']) return target;
        }
    }

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget fslgtt =
                new FindSmallestLetterGreaterThanTarget();
        char[] letters1 = new char[]{'c', 'f', 'j'};
        System.out.println(fslgtt.nextGreatestLetter(letters1,'a'));
        System.out.println(fslgtt.nextGreatestLetter(letters1,'e'));
        System.out.println(fslgtt.nextGreatestLetter(letters1,'j'));

    }
}
