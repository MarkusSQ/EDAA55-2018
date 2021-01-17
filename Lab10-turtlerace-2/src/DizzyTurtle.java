

public class DizzyTurtle extends RaceTurtle {
	int d;
	int t = 0;
	int q =6;
	int c = 0;
	

	public DizzyTurtle(RaceWindow w, int nbr, int d) {
		super(w, nbr);
		this.d = d;

	}

	void raceStep() { //Väldigt mycket mer avancerad än vad den behöver vara

		if (t < 3 || (t < 6 && c == 1)) {
			if (super.getDirection() >= 90) {
				super.left(d * (-3));
				t = 6;
				super.raceStep();
			} else {
				super.left(d * 3);
				t++;
				super.raceStep();
			}
		} else {
			if (super.getDirection() <= -90) {
				super.left(d * 3);
				t = 0;
				super.raceStep();
			} else {
				super.left(d * (-3));
				q--;
				super.raceStep();
				if (q == 0) {
					t = 0;
					q = 6;
					c = 1;
				}
			}
		}
	}

	public String toString() {
		return super.toString() + "- " + "DizzyTurtle " + "(Yrsel: " + Integer.toString(d) + ")";
	}

}