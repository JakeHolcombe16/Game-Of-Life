package life6visitor;

// The main program used to invoke the game of life system.
 
public class Main {

    public static void main(String[] args) {
        // Create an instance of the game with a 20x20 life grid
    	//   shown in a 500x500 window
    	GameOfLife gol = new GameOfLife(20,20);
    	GameOfLifeUI golui = new GameOfLifeUI("The Game of Life", 500,500, gol);
    }
}

