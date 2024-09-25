package life2state;

public interface CellState {
	public abstract CellState live();
	public abstract CellState dead();
	public boolean isAlive();
}


