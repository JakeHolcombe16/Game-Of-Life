package life4command;

public class LiveCommand extends LifeCommand{
	public LiveCommand(Cell r) {
		super(r);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		receiver.live();
	}
}
