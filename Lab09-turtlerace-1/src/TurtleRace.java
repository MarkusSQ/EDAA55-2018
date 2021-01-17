import java.util.ArrayList;

public class TurtleRace {

	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		ArrayList<RaceTurtle> race = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> finish = new ArrayList<RaceTurtle>();
		
		for (int i = 1; i < 9; i++) {
			race.add(new RaceTurtle(w, i));
		}
		
		
		while(race.size() > 0) {
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
		
		for (int i = 1; i<4; i++) {
			RaceTurtle h = finish.get(i);
				 System.out.println("På plats " + Integer.toString(i) + ": " + h.toString());
			
			
			
			
		}
		
	}

}
