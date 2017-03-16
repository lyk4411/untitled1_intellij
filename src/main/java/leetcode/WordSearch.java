package leetcode;

/**
 * Created by lyk on 2017/3/16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class WordSearch {
    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] boards = new char[][]{{'a','b','c','d','e','f'},
                                        {'g','h','i','j','k','l'},
                                        {'m','o','p','q','r','s'},
                                        {'t','u','v','w','x','y'}};
        String word1 = new String("hello");
        String word2 = new String("pvwq");
        System.out.println(ws.exist(boards,word1));
        System.out.println(ws.exist(boards,word2));
    }
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1)
                || exist(board, y, x-1, word, i+1)
                || exist(board, y+1, x, word, i+1)
                || exist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }
}
