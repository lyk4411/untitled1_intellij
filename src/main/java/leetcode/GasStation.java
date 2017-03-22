package leetcode;

/**
 * Created by lyk on 2017/3/22.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class GasStation {
    public static void main(String[] args) {
        GasStation gs = new GasStation();
        int[] gas = new int[]{1,2,3,4,5,6};
        int[] cost = new int[]{4,5,6,1,2,3};
        System.out.println(gs.canCompleteCircuit(gas,cost));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumRemaining = 0; // track current remaining
        int total = 0; // track total remaining
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int remaining = gas[i] - cost[i];

            //if sum remaining of (i-1) >= 0, continue
            if (sumRemaining >= 0) {
                sumRemaining += remaining;
                //otherwise, reset start index to be current
            } else {
                sumRemaining = remaining;
                start = i;
            }
            total += remaining;
        }

        if (total >= 0){
            return start;
        }else{
            return -1;
        }
    }
}
