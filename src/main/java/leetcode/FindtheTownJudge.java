package leetcode;

/**
 * Created by lyk on 2019-8-9.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindtheTownJudge {
    public int findJudge(int N, int[][] trust) {

        int[] in_deg = new int[N+1];
        int[] out_deg = new int[N+1];

        for(int i = 0; i < trust.length;i++){
            out_deg[trust[i][0]]++;
            in_deg[trust[i][1]]++;
        }
        int idx = -1;
        for(int j = 1;j< N+1;j++){
            if(out_deg[j] == 0){
                idx = j;
                if(in_deg[idx] == N-1){
                    return idx;
                }
            }
        }
        return -1;
    }
}
