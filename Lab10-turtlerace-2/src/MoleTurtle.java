import java.util.Random;

public class MoleTurtle extends RaceTurtle {
	int o = 4; //Attribut ej nödvändigt

	public MoleTurtle(RaceWindow w, int nbr) {
		super(w, nbr);

	}

	void raceStep() {
		Random rand = new Random();

		if (o < 5) {
			super.penUp();
			o = 1 + rand.nextInt(9);
			super.raceStep();
		} else {
			super.penDown();
			o = 1 + rand.nextInt(9);
			super.raceStep();
		}
	}
	
	public String toString() {
		return super.toString() + "- " + "MoleTurtle";
	}
}
