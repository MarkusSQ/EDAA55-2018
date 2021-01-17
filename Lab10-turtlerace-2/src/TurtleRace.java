import java.util.ArrayList;
import java.util.Random;

public class TurtleRace {

	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		ArrayList<RaceTurtle> race = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> finish = new ArrayList<RaceTurtle>();
		Random rand = new Random();
		for (int i = 1; i < 9; i++) {
			int l = rand.nextInt(2);
			if (l == 0) {
				race.add(new MoleTurtle(w, i));
				System.out.println("Nummer " + Integer.toString(i) + "- " + "MoleTurtle");
			} else if(l == 1) {
				int g = 1 + rand.nextInt(99);
				race.add(new AbsentMindedTurtle(w, i, g));
				System.out.println("Nummer " + Integer.toString(i) + "- " + "AbsentMindedTurtle (" + Integer.toString(g) + "% frånvarande)");
			} else {
				int d = 1 + rand.nextInt(4);
				race.add(new DizzyTurtle(w, i, d));
				System.out.println("Nummer " + Integer.toString(i) + "- " + "DizzyTurtle" + "(Yrsel:" + Integer.toString(d + 1) + ")" );
			}
	
		}
		
		

		while (race.size() > 0) {
			for (int k = 0; k < race.size(); k++) {
				RaceTurtle t = race.get(k);
				t.raceStep();
				RaceWindow.delay(10);
				if (t.getX() >= RaceWindow.X_END_POS) {
					race.remove(k);
					finish.add(t);
					k--;
				}
			}

		}

		for (int i = 1; i < 4; i++) {
			RaceTurtle h = finish.get(i);
			System.out.println("På plats " + Integer.toString(i) + ": " + h.toString());

		}

	}

}
