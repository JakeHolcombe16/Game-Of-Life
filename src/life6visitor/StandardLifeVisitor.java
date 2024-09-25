package life6visitor;

import java.util.ArrayList;
import java.util.List;

public class StandardLifeVisitor extends LifeVisitor{
//    List<LifeCommand> lifeCommands = new ArrayList<>();	
	
	private List<LifeCommand> lifeCommands;

	public StandardLifeVisitor(List<LifeCommand> lifeCommands) {
		this.lifeCommands = lifeCommands;
	}
	@Override
	public void visitDeadCell(Cell c) {
		// TODO Auto-generated method stub
		if (c.nbrAliveNeighbors() == 3) {
			lifeCommands.add(new LiveCommand(c));
	}
	}

	@Override
	public void visitAliveCell(Cell c) {
		if(c.nbrAliveNeighbors() < 2 || c.nbrAliveNeighbors() > 3) {
			lifeCommands.add(new DieCommand(c));
		}
			
	}
}
		


