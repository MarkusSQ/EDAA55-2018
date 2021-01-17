import java.util.Random;

/**
 * Skapar en sköldpadda som ska springa i fönstret w och som har start- nummer
 * nbr. Sköldpaddan startar med pennan nere och nosen vänd åt höger.
 */
public class RaceTurtle extends Turtle {
	private int nbr;

	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		this.nbr = nbr;
		super.penDown(); //behöver inte ha super då vi inte kan blanda ihop med nåt
		super.left(-90);
	}

	/**
	 * Låter sköldpaddan gå framåt ett steg. Stegets längd ges av ett
	 * slumptal (heltal) mellan 1 och 6. 
	 */
	
	void raceStep() {
		Random rand = new Random();
		int c = 1 + rand.nextInt(5);
		super.forward(c);
	}

	/**
	 * Returnerar en läsbar representation av denna RaceTurtle, på formen "Nummer x" där
	 * x är sköldpaddans startnummer.
	 */
	
	public String toString() {
		return "Sköldpaddans nummer:" + this.nbr;
		
}
}
