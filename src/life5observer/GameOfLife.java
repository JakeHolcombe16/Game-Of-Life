package life5observer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import edu.du.dudraw.Draw;

public class GameOfLife {
	
 
    // rows and cols for the game
    private int rows;
    private int cols;
    private List observers = new ArrayList<GameOfLifeUI>();
    private Cell[][] grid;

    
    public GameOfLife(int rows, int cols){
 	    this.rows = rows;
 	    this.cols = cols;
 	    this.grid = new Cell[rows][cols];
 	    setupGrid(grid);
 	    }
             
         
    
    
    private void setupGrid(Cell[][] g) {
		for(int h = 0; h < rows; h++ ) {
			for (int o = 0; o < cols; o++) {
				g[h][o] = new Cell();
			}
		}
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < cols; y++) {
				for(int rCt = -1; rCt <= 1; rCt++) {
					for(int cCt = -1; cCt <= 1; cCt++) {
						int rC = x + rCt;
						int cC = y + cCt;
						
						if(rC < 0) {
							rC = rows-1;
						}else if (rC > rows -1) {
							rC = 0; 
						} if (cC < 0) {
							cC = cols-1;
						}else if(cC > cols-1) {
							cC = 0;
						}
						if(x == rC && y == cC) {
							
						}
						else {						
							g[x][y].addNeighbor(g[rC][cC]);
						}
					}
				}
			}
		}
	}
    
    public Cell getCell(int row, int col) {
    	return grid[row][col];
    }
    
    public int getRows() {
    	return this.rows;
    }
    
    public int getCols() {
    	return this.cols;
    }
    
    public void notifyObserver() {
    	for(int i = 0; i < observers.size(); i++) {
    		LifeObserver observer = (LifeObserver)observers.get(i);
    		observer.update();
    	}
    }
    
    public void attachObserver(LifeObserver observer) {
    	observers.add(observer);
    }
    public void detachObserver(LifeObserver observer) {
    	observers.remove(observer);
    }
	
	public void advance() {
        List<LifeCommand> lifeCommands = new ArrayList<>();
        int n;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
            	n = grid[i][j].nbrAliveNeighbors();
            	if (grid[i][j].isAlive()) {
            		if(n < 2 || n > 3) {
            			lifeCommands.add(new DieCommand(grid[i][j]));
            		}
            		
            	}
            	else {
            		if (!grid[i][j].isAlive() && n == 3){
            			
            			lifeCommands.add(new LiveCommand(grid[i][j]));
            			
            		}
            		 
//            			lifeCommands.add(new LiveCommand(cell));
            	}
            }
        }
        
            	for(LifeCommand lifeCommand : lifeCommands) {
            		lifeCommand.execute();
            	}
//            	update();
            	notifyObserver();
            }




	





	
}
