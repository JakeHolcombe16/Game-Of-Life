package life2state;
import java.util.ArrayList;

public class Cell {
	private CellState state;
	private ArrayList<Cell> neighbors;

	
	public Cell() {
		this.neighbors = new ArrayList<Cell>();
		this.state = new DeadState();
	}
	
	public boolean isAlive() {
		return this.state.isAlive();
	}
	public void dead() {
		this.state = new DeadState();
	}
	public void live() {
		this.state = new AliveState();
	}
	
	public void addNeighbor(Cell neighborCell) {
		neighbors.add(neighborCell);
	}
	
//	Checks to see if the neighbor is alive then counts up
   	public int nbrAliveNeighbors() {
        int neighbors = 0;
        for (int i = 0; i<this.neighbors.size();i++) {
        	if(this.neighbors.get(i).isAlive()) {
        		neighbors++;
        	}
        }
        return neighbors;
   	}
}
