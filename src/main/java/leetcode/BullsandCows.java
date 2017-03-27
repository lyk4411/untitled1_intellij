package leetcode;

/**
 * Created by lyk on 2017/3/27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BullsandCows {
    public static void main(String[] args) {
        BullsandCows bc = new BullsandCows();
        System.out.println(bc.getHint("1134","3516"));
        System.out.println(bc.getHint("1134","1134"));
        System.out.println(bc.getHint("1134","5131"));
    }
    public String getHint(String secret, String guess) {
        int countBull=0;
        int countCow =0;
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];

        for(int i=0; i<secret.length(); i++){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);

            if(c1==c2)
                countBull++;
            else{
                arr1[c1-'0']++;
                arr2[c2-'0']++;
            }
        }
//        System.out.print("arr1:");
//        for (int i = 0; i < arr1.length; i++) {
//            System.out.print(arr1[i]);
//        }
//        System.out.println();
//
//        System.out.print("arr2:");
//        for (int i = 0; i < arr2.length; i++) {
//            System.out.print(arr2[i]);
//        }
//        System.out.println();

        for(int i=0; i<10; i++){
            countCow += Math.min(arr1[i], arr2[i]);
        }

        return countBull+"A"+countCow+"B";
    }
//    public String getHint(String secret, String guess) {
//        int countBull=0;
//        int countCow=0;
//
//        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//
//        //check bull
//        for(int i=0; i<secret.length(); i++){
//            char c1 = secret.charAt(i);
//            char c2 = guess.charAt(i);
//
//            if(c1==c2){
//                countBull++;
//            }else{
//                if(map.containsKey(c1)){
//                    int freq = map.get(c1);
//                    freq++;
//                    map.put(c1, freq);
//                }else{
//                    map.put(c1, 1);
//                }
//            }
//        }
//
//        //check cow
//        for(int i=0; i<secret.length(); i++){
//            char c1 = secret.charAt(i);
//            char c2 = guess.charAt(i);
//
//            if(c1!=c2){
//                if(map.containsKey(c2)){
//                    countCow++;
//                    if(map.get(c2)==1){
//                        map.remove(c2);
//                    }else{
//                        int freq = map.get(c2);
//                        freq--;
//                        map.put(c2, freq);
//                    }
//                }
//            }
//        }
//
//        return countBull+"A"+countCow+"B";
//    }
}
