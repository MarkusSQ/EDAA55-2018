package cardgame;
import pair.*;

public class Patiens {
	private static final int NBR_ITERATIONS = 1000000;
	public static void main(String[] args) {
		double passed = 0;
		for(int i = 0; i<NBR_ITERATIONS; i++) {
			if(patiens()) {
				passed++;
			}
			if(i%100==0 && i!= 0) {
				System.out.println("Passed: " + (passed*100/i)+ "%");
			}
		}
		System.out.println("COMPLETE: Final result:" + (passed*100/NBR_ITERATIONS) + " %passed");
	}
	
	
	public static boolean patiens() {
		PairSet cardDeck = new PairSet(4,13);
		
		int count = 0;
		while(cardDeck.more()) {
			Pair picked = cardDeck.pick();
			
			if(picked.second() == count) {
				return false;
			}
			
			count = (count + 1)%3;
		}
		return true;
	}
}
