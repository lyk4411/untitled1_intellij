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
    // 这里直接参照大神Chidong的帖子来做，我们就用上面那个例子，有四个洗衣机，
    // 装的衣服数为[0, 0, 11, 5]，最终的状态会变为[4, 4, 4, 4]，那么我们将二
    // 者做差，得到[-4, -4, 7, 1]，这里负数表示当前洗衣机还需要的衣服数，正
    // 数表示当前洗衣机多余的衣服数。我们要做的是要将这个差值数组每一项都变
    // 为0，对于第一个洗衣机来说，需要四件衣服可以从第二个洗衣机获得，那么就
    // 可以把-4移给二号洗衣机，那么差值数组变为[0, -8, 7, 1]，此时二号洗衣机
    // 需要八件衣服，那么至少需要移动8次。然后二号洗衣机把这八件衣服从三号洗
    // 衣机处获得，那么差值数组变为[0, 0, -1, 1]，此时三号洗衣机还缺1件，就从
    // 四号洗衣机处获得，此时差值数组成功变为了[0, 0, 0, 0]，成功。那么移动的
    // 最大次数就是差值数组中出现的绝对值最大的数字，8次，参见代码如下：
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
