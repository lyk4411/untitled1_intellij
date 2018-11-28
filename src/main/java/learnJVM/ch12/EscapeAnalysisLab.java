package learnJVM.ch12;

/**
 * Created by lyk on 2018-11-28.
 * Package name: learnJVM.ch12
 * Porject name: untitled1
 */
public class EscapeAnalysisLab {
    public static void main(String[] args) throws Exception {
        int sum = 0;
        int count = 1000000;
        for (int i = 0; i < count ; i++) {
            sum += getScore(i);
        }
        System.out.println(sum);
        System.in.read();
    }

    private static int getScore(int score) {
        Card card = new Card(score);
        int i = card.getScore();
        return i;
    }
}

class Card {
    private int score;

    public Card(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}