/**
 * Created by lyk on 2016/7/1.
 */

class StarDiagram extends Diagram {
    public StarDiagram(char c) {
        super(c);
    }

    @Override
    protected void print(int size) {
        for (int i = 0; i < size + 2; i++) {
            System.out.print(c);
        }
        System.out.println();
    }

    @Override
    protected void printContent(String msg) {
        System.out.print("*");
        System.out.print(msg);
        System.out.println("*");
    }
}