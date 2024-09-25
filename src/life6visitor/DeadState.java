package life6visitor;

public class DeadState implements CellState{
	private static DeadState ins;
	
	private DeadState() {
		
	}
	
	
	@Override
	public CellState live() {
		// TODO Auto-generated method stub
		return AliveState.create();
	}

	@Override
	public CellState dead() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static DeadState create() {
		if(ins == null) {
			ins = new DeadState();
		}
		return ins;
	}
	
	public void accept(LifeVisitor visitor, Cell c) {
		visitor.visitDeadCell(c);
	}

}
