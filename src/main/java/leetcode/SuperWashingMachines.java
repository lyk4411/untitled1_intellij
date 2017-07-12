package leetcode;

/**
 * Created by lyk on 2017/7/12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SuperWashingMachines {
    public static void main(String[] args) {
        SuperWashingMachines swm = new SuperWashingMachines();
        int[] machines = new int[]{0,0,11,5};
        System.out.println(swm.findMinMoves(machines));
    }

    public int findMinMoves(int[] machines) {
        int total = 0;
        for(int i: machines) total+=i;
        if(total%machines.length!=0) return -1;
        int avg = total/machines.length, cnt = 0, max = 0;
        for(int load: machines){
            cnt += load-avg; //load-avg is "gain/lose"
            max = Math.max(Math.max(max, Math.abs(cnt)), load-avg);
        }
        return max;
    }
}
