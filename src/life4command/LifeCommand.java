package life4command;

public abstract class LifeCommand {
	protected Cell receiver;

	public LifeCommand(Cell receiver) {
		this.receiver = receiver;
	}
	public abstract void execute();
}
