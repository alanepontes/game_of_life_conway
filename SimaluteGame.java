package game_of_life;

public class SimaluteGame {

	public static void main(String[] args) {

		GameBoard board = new GameBoard();
		board.initWorld();
		int i = 0;
		while(i < 1) {
			board.simulateGame();
			board.printWorld();
			i++;
		}
	}

}
