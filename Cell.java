package game_of_life;

public abstract class Cell {
	StatusCell statusCell;
	
	public Boolean isAlive() {
		return statusCell.isAlive();
	}
	
	public Boolean isDead() {
		return statusCell.isDead();
	}
	
	public Boolean isZumbi() {
		return statusCell.isZumbi();
	}
	
	@Override
	public String toString() {
		return statusCell.toString();
	}
	
	public void setStatusCell(StatusCell statusCell) {
		this.statusCell = statusCell;
	}
}
