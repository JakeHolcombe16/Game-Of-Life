package life2state;

import java.awt.Color;
import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;

// Game of life main app using DuDraw
// Use mouse clicks to toggle cells
// Use spacebar to advance game

public class GameOfLifeApp implements DrawListener {
	// width and height in pixels
	private int width;
    private int height;
    private Draw window;
 
    // rows and cols for the game
    private int rows;
    private int cols;
    private Cell[][] grid; 
   
    
    public GameOfLifeApp(String title, int rows, int cols, int width, int height) {
        
    	// Save the instance variables
    	this.rows = rows;
		this.cols = cols;
		this.width = width;
		this.height = height;
		
		// Setup the grid
	    this.grid = new Cell[rows][cols];
	    
	    setupGrid(grid);
        
         
        // Setup the DuDraw board
        window = new Draw(title);
        window.setCanvasSize(width, height);
        window.setXscale(0, width);
		window.setYscale(0, height);
       
		// Add the mouse/key listeners
        window.addListener(this);
        
        // Draw the initial board
	    update();
    }
    
    private void drawGrid() {
        
    	window.setPenColor(Color.black);
 		
        int cellWidth = width / cols;
        int cellHeight = height / rows;
     
        for (int i = 0; i <= rows; i++) {
        	window.line(0, i * cellHeight, this.width, i * cellHeight);
        }
        
        for (int i = 0; i <= cols; i++) {
        	window.line(i * cellWidth, 0, i * cellWidth, this.height);
        }
    }
     
    private void drawLives() {
    	int cellWidth = width / cols;
        int cellHeight = height / rows;
        
    	window.setPenColor(Color.red);
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
        		if (grid[i][j].isAlive()) {
        			// This is the center and half width/height
        			window.filledRectangle((j * cellWidth)+(cellWidth/2), (i * cellHeight)+(cellHeight/2), cellWidth/2, cellHeight/2);
                }
            }
        }
    }
   
	
	

    // This method implements the rules of the Game of Life. For each cell,
    //   we simple find the number of neighbors and then bring the cell to life
    //   if appropriate.
    public void advance() {
        Cell[][] newGrid = new Cell[rows][cols];
        setupGrid(newGrid);
        int n = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                n = grid[i][j].nbrAliveNeighbors();
                if (grid[i][j].isAlive()) {
                    if(n == 3 || n ==2) {
                    	newGrid[i][j].live();
                    }
                } else {
                    if (n == 3) {
                        newGrid[i][j].live();
                    }
                }
            }
        }
        grid = newGrid;
        update();
       
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
						else {
							g[x][y].addNeighbor(g[rC][cC]);
						}
					}
				}
			}
		}
		
		
	}

    // Below are the mouse/key listeners
    
	@Override
	public void keyPressed(int key) {
		// This is the advance button
		// Only advance for spacebar (ascii 32)
		if (key==32) {
			advance();
		}
	}

	@Override
	public void keyReleased(int key) {
		// Do nothing
	}

	@Override
	public void keyTyped(char key) {
		// Do nothing
	}

	@Override
	public void mouseClicked(double arg0, double arg1) {
		// Do nothing
	}

	@Override
	public void mouseDragged(double x, double y) {
		// Do nothing
	}

	@Override
	public void mousePressed(double x, double y) {
		// This is the toggle of grid locations
		int cellWidth = width / cols;
        int cellHeight = height / rows;
        
        int cellLocRow = (int)(y / cellHeight);
        int cellLocCol = (int)(x / cellWidth);
        
        if(grid[cellLocRow][cellLocCol].isAlive()) {
        	grid[cellLocRow][cellLocCol].dead();
        }else {
        	grid[cellLocRow][cellLocCol].live();
        	
        }
		update();        
	}

	@Override
	public void mouseReleased(double x, double y) {
		// Do nothing
	}

	@Override
	public void update() {
		// Redraw the entire board
		window.clear(Color.white);  // Clear in white
	 	drawGrid();
	 	drawLives();
	}
	
	
        
}