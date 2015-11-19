package game_of_life;

public class Dead implements StatusCell {

	@Override
	public Boolean isAlive() {
		return false;
	}

	@Override
	public Boolean isZumbi() {
		return false;
	}

	@Override
	public Boolean isDead() {
		return true;
	}
	
	@Override
	public String toString() {
		return "*";
	}

}
