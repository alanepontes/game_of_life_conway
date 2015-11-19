package game_of_life;

public class Alive implements StatusCell {

	@Override
	public Boolean isAlive() {
		return true;
	}

	@Override
	public Boolean isZumbi() {
		return false;
	}

	@Override
	public Boolean isDead() {
		return false;
	}
	
	@Override
	public String toString() {
		return "#";
	}

}
