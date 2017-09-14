package headfirst.command.simpleremote.log;

/**
 * Created by lyk on 2017/9/14.
 * Package name: headfirst.command.simpleremote.log
 * Porject name: untitled1
 */
public class DeleteCommand extends Command{
    public DeleteCommand(String name) {
        super(name);
    }

    public void execute(String args) {
        this.args = args;
        configOperator.insert(args);
    }

    public void execute() {
        configOperator.insert(this.args);
    }
}
