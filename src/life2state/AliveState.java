package life2state;

public class AliveState implements CellState{

	@Override
	public CellState live() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public CellState dead() {
		// TODO Auto-generated method stub
		return new DeadState();
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
