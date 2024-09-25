package life6visitor;

public class AliveState implements CellState{
	private static AliveState ins;
	
	private AliveState() {
		
	}
	
	@Override
	public CellState live() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public CellState dead() {
		// TODO Auto-generated method stub
		return DeadState.create();
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public static AliveState create() {
		if(ins == null) {
			ins = new AliveState();
		}
		return ins;
	}
	
	public void accept(LifeVisitor visitor, Cell c) {
		visitor.visitAliveCell(c);
	}
	
}
