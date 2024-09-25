package life5observer;

public abstract class LifeCommand {
	protected Cell receiver;

	public LifeCommand(Cell receiver) {
		this.receiver = receiver;
	}
	public abstract void execute();
}
