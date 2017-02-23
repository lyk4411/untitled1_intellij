package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/2/22.
 * Package name: leetcode
 * Porject name: untitled1
 */

public class RelativeRanks {
    public static void main(String[] args){
        RelativeRanks rr = new RelativeRanks();
        String[] results = rr.findRelativeRanks1(new int[]{12,32,15,56,7});
        for(String result:results){
            System.out.println(result);
        }

//        List<Integer> nums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
//        System.out.println("sum is:"+nums.stream().filter(num -> num != null).
//        distinct().mapToInt(num -> num * 2).
//        peek(System.out::println).skip(2).limit(4).sum());
//        Stream.of("one", "two", "three", "four")
//                .filter(e -> e.length() > 3)
//                .peek(e -> System.out.println("Filtered value: " + e))
//                .map(String::toUpperCase)
//                .peek(e -> System.out.println("Mapped value: " + e))
//                .collect(Collectors.toList());
//
//        IntStream.generate(() -> (int) (System.nanoTime() % 100)).
//                limit(10).forEach(System.out::println);
//
//        Stream.iterate(0, n -> n + 3).limit(10). forEach(x -> System.out.print(x + " "));
    }

    public String[] findRelativeRanks1(int[] nums) {
        int[][] pair = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }

        Arrays.sort(pair, (a1, a2) -> (a2[0] - a1[0]));

        String[] result = new String[nums.length];

//        for(int i=0;i< pair.length;i++){
//            for(int j=0;j<pair[i].length;j++){
//                System.out.println(pair[i][j]);
//            }
//        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[pair[i][1]] = "Gold Medal";
            }
            else if (i == 1) {
                result[pair[i][1]] = "Silver Medal";
            }
            else if (i == 2) {
                result[pair[i][1]] = "Bronze Medal";
            }
            else {
                result[pair[i][1]] = (i + 1) + "";
            }
        }

        return result;
    }

    public String[] findRelativeRanks(int[] nums) {
        String[] s = new String[nums.length];
        int flag = 1;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > max)
                max = nums[i];
        }
        int[] sup = new int[max + 1];
        for (int i = 0; i < sup.length; i++) {
            sup[i] = 0;
        }

        for (int i = 0; i < nums.length; i++){
            sup[nums[i]] = 1;
        }

//        for(int ss:sup){
//            System.out.println(ss);
//        }

        for (int i = sup.length - 1; i >= 0; i--) {
            if (sup[i] == 1) {
                for (int j = 0; j < nums.length; j++)
                    if (nums[j] == i)
                        s[j] = Integer.toString(flag);
                flag++;
            }
        }
        for (int i = 0; i < s.length; i++)
            if (s[i].equals("1"))
                s[i] = "Gold Medal";
            else if (s[i].equals("2"))
                s[i] = "Silver Medal";
            else if (s[i].equals("3"))
                s[i] = "Bronze Medal";
        return s;
    }
}
