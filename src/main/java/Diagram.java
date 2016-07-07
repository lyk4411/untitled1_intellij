/**
 * Created by lyk on 2016/7/1.
 */
abstract class Diagram {
    protected char c;

    public Diagram(char c) {

        this.c = c;
    }

    abstract protected void print(int size);

    abstract protected void printContent(String msg);

    public final void display(String msg) {
        int len = msg.getBytes().length;
        print(len);
        printContent(msg);
        print(len);
    }
}
