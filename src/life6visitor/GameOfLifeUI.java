package life6visitor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;

public class GameOfLifeUI implements LifeObserver, DrawListener{
	private int width;
    private int height;
    private Draw window;
//    private int rows;
//    private int cols;
	private GameOfLife gameoflife;
	private String title; 
    
    public GameOfLifeUI(String title, int width, int height, GameOfLife subject) {
    	this.width = width;
    	this.height = height;
    	this.title = title;
    	this.gameoflife = subject;
    	gameoflife.attachObserver(this);
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
 		
        int cellWidth = width / gameoflife.getCols() ;
        int cellHeight = height / gameoflife.getRows();
     
        for (int i = 0; i <= gameoflife.getRows(); i++) {
        	window.line(0, i * cellHeight, this.width, i * cellHeight);
        }
        
        for (int i = 0; i <= gameoflife.getCols(); i++) {
        	window.line(i * cellWidth, 0, i * cellWidth, this.height);
        }
    }
    
    private void drawLives() {
    	int cellWidth = width / gameoflife.getCols();
        int cellHeight = height / gameoflife.getRows();
        
    	window.setPenColor(Color.red);
        for (int i = 0; i < gameoflife.getRows(); i++) {
        	for (int j = 0; j < gameoflife.getCols(); j++) {
        		if (gameoflife.getCell(i, j).isAlive()) {
        			// This is the center and half width/height
        			window.filledRectangle((j * cellWidth)+(cellWidth/2), (i * cellHeight)+(cellHeight/2), cellWidth/2, cellHeight/2);
                }
            }
        }
    }
    
    
    @Override
	public void keyPressed(int key) {
		// This is the advance button
		// Only advance for spacebar (ascii 32)
		if (key==32) {
			gameoflife.advance();
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
		int cellWidth = width / gameoflife.getCols();
        int cellHeight = height / gameoflife.getRows();
        
        int cellLocRow = (int)(y / cellHeight);
        int cellLocCol = (int)(x / cellWidth);
        
        if(gameoflife.getCell(cellLocRow, cellLocCol).isAlive()) {
        	gameoflife.getCell(cellLocRow, cellLocCol).dead();
        }else {
        	gameoflife.getCell(cellLocRow, cellLocCol).live();
        	
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
