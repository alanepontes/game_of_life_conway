package game_of_life;

import java.util.Random;

public class GameBoard {

	public static final int ROWS = 3;
	public static final int COLUMNS =  3;
	
	Cell[][] world = new Cell[ROWS][COLUMNS];
	private static Random statusCell = new Random();

	public static boolean getStatusCell() {
		return statusCell.nextBoolean();
	}

	private Boolean isLifeAt(int row, int col) {
		return (row >= 0 && row < ROWS && col >= 0 && col < COLUMNS && (world[row][col].isAlive())) ;
	}
	
	private void generateWorld() {
		for (int row = 0; row < world.length; row++) {
			for (int col = 0; col < world[row].length; col++) {
				world[row][col] = GameBoard.getStatusCell() ? new CellAlive()
						: new CellDead();
			}
		}
	}

	public void initWorld() {
		this.generateWorld();
	}

	public void simulateGame() {
		for (int row = 0; row < world.length; row++) {
			for (int col = 0; col < world[row].length; col++) {
				
				int numberNeighbours = this.countNeighbours(row, col);
				
				if(world[row][col].isAlive()) {
					if(this.underPopulation(numberNeighbours)) {
						world[row][col] = new CellDead(); 
					} else if (this.survival(numberNeighbours)) {
						continue;
						
					} else if(this.overcrowding(numberNeighbours)){
						world[row][col] = new CellDead();
					}
				} else {
					if(this.reproduction(numberNeighbours)) {
						world[row][col] = new CellAlive();
					}
				}
			}
		}
	}
		
	public void printWorld() {
		
		for (Cell[] arrayCell : world) {
			for (Cell cell : arrayCell) {
				System.out.print(cell.toString());
			}
			System.out.println("\n");
		}
	}

	public int countNeighbours(int row, int col) {
		int numberNeighbours = 0;
		for(Neighbours neighbours : Neighbours.values()) {
			if(this.isLifeAt(row + neighbours.row, col + neighbours.col))
				numberNeighbours++;
		}
		return numberNeighbours;
	}
	
	public Boolean underPopulation(int numberNeighbours) {
		return numberNeighbours < 2 ? true : false;
	}

	public Boolean survival(int numberNeighbours) {
		return numberNeighbours == 2 || numberNeighbours == 3 ? true : false;
	}

	public Boolean overcrowding(int numberNeighbours) {
		return numberNeighbours > 3 ? true : false;
	}

	public Boolean reproduction(int numberNeighbours) {
		return numberNeighbours == 3 ? true : false;
	}
	
	public enum Neighbours {
		NORTHWEST(-1, -1),
	    NORTH(0, -1),
	    NORTHEAST(1, -1),
	    EAST(1, 0),
	    SOUTHEAST(1, 1),
	    SOUTH(0, 1),
	    SOUTHWEST(-1, 1),
	    WEST(-1, 0),
	    ;
		
		final int row;
		final int col;
		
		Neighbours(int row, int col) {
			this.row = row;
	        this.col = col;
		}
	}
}
