package game_of_life;

public class Zumbi implements StatusCell {

	@Override
	public Boolean isAlive() {
		return false;
	}

	@Override
	public Boolean isZumbi() {
		return true;
	}

	@Override
	public Boolean isDead() {
		return false;
	}

}
