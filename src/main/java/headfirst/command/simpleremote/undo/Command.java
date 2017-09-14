package headfirst.command.simpleremote.undo;

public interface Command {
	public void execute();
	public void undo();
}
