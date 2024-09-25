package life6visitor;

public class DieCommand extends LifeCommand {

	public DieCommand(Cell r) {
		super(r);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		receiver.dead();
	}

}
