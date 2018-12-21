package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * Created by lyk on 2018-12-21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] map = new int[deck.length];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<deck.length;i++){
            queue.offer(i);
        }
        int count=0;
        System.out.println(queue);
        for(int i=0;queue.size()>0;i++){
            if(i%2==0){
                map[count++]=queue.poll();
            }else{
                queue.offer(queue.poll());
            }
        }
        IntStream.of(map).forEach(n -> System.out.print(n + " : "));
        System.out.println();
        Arrays.sort(deck);
        IntStream.of(deck).forEach(n -> System.out.print(n + " : "));
        System.out.println();
        int[] result = new int[deck.length];
        for(int i=0;i<deck.length;i++){
            result[map[i]] = deck[i];
        }
        return result;
    }

    public static void main(String[] args) {
        RevealCardsInIncreasingOrder rciio = new RevealCardsInIncreasingOrder();
        IntStream.of(rciio.deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7})).
                forEach(n -> System.out.print(n + " : "));
    }

}
