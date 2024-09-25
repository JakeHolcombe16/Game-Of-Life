package life6visitor;

import java.util.List;

public abstract class LifeVisitor {
	public abstract void visitAliveCell(Cell c);
	public abstract void visitDeadCell(Cell c);
	public void visit(Cell c) {
		c.accept(this, c);
	}
	
}
