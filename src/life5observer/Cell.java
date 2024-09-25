package life5observer;
import java.util.ArrayList;

public class Cell {
	private CellState state;
	private ArrayList<Cell> neighbors;

	
	public Cell() {
		this.state = DeadState.create();
		this.neighbors = new ArrayList<Cell>();
	}
	
	public boolean isAlive() {
		return this.state.isAlive();
	}
	public void dead() {
		this.state = DeadState.create();
	}
	public void live() {
		this.state = AliveState.create();
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
