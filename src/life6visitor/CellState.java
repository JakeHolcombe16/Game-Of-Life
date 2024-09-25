package life6visitor;

public interface CellState {
	public abstract CellState live();
	public abstract CellState dead();
	public boolean isAlive();
	public abstract void accept(LifeVisitor visitor, Cell c);
}


