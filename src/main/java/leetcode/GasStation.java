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
        int sum = 0;
        int total = 0;
        int j = -1;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(sum < 0) {   //之前的油量不够到达当前加油站
                j = i;
                sum = 0;
            }
        }
        if (total < 0) return -1;    //所有加油站的油量都不够整个路程的消耗
        else return j + 1;
    }
}
