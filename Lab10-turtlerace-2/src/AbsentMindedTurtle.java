import java.util.Random;

public class AbsentMindedTurtle extends RaceTurtle {
	int g; // Attribut här nödvändigt

	public AbsentMindedTurtle(RaceWindow w, int nbr, int g) {
		super(w, nbr);
		this.g = g;
		
	}
	
	void raceStep() {
		Random rand = new Random();
		int p = rand.nextInt(99);
		if(p<g) {
			super.raceStep();
		}
	}
	
	public String toString() {
		return super.toString() + "- " + "AbsentMindedTurtle" + "("  + Integer.toString(100 - g) + "% frånvaro)";
	}

}
