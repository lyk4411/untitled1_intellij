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
        int m = board.length;
        int n = board[0].length;

        boolean result = false;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board,word,i,j,0)){
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int k){
        int m = board.length;
        int n = board[0].length;

        if(i<0 || j<0 || i>=m || j>=n){
            return false;
        }

        if(board[i][j] == word.charAt(k)){
            char temp = board[i][j];
            board[i][j]='#';
            if(k==word.length()-1){
                return true;
            }else if(dfs(board, word, i-1, j, k+1)
                    ||dfs(board, word, i+1, j, k+1)
                    ||dfs(board, word, i, j-1, k+1)
                    ||dfs(board, word, i, j+1, k+1)){
                return true;
            }
            board[i][j]=temp;
        }

        return false;
    }
}
