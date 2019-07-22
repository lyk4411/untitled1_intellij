package leetcode;

/**
 * Created by lyk on 2019-7-22.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age: ages) count[age]++;

        int ans = 0;
        for (int ageA = 0; ageA <= 120; ageA++) {
            int countA = count[ageA];
            for (int ageB = 0; ageB <= 120; ageB++) {
                int countB = count[ageB];
                if (ageA * 0.5 + 7 >= ageB) continue;
                if (ageA < ageB) continue;
                if (ageA < 100 && 100 < ageB) continue;
                ans += countA * countB;
                if (ageA == ageB) ans -= countA;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FriendsOfAppropriateAges faa = new FriendsOfAppropriateAges();
        int[] age1 = new int[]{16,16};
        int[] age2 = new int[]{16,17,18};
        int[] age3 = new int[]{20,30,100,110,120};
        System.out.println(faa.numFriendRequests(age1));
        System.out.println(faa.numFriendRequests(age2));
        System.out.println(faa.numFriendRequests(age3));
    }
}
