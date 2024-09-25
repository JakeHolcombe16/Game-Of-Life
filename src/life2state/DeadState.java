package life2state;

public class DeadState implements CellState {

	@Override
	public CellState live() {
		// TODO Auto-generated method stub
		return new AliveState();
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

}
