import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class FleraKvadrater {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "Kvadrater");
		int oldX = 250;
		int oldY = 250;
		Square sq = new Square(250, 250, 100);
		sq.draw(w);
		while (true) {
		w.waitForMouseClick();
		int a = w.getMouseX();
		int b = w.getMouseY();
		for (int i = 1; i<=10; i++) {
			sq.move((a-oldX)/10, (b-oldY)/10);
			sq.draw(w);
			}
		oldX = w.getX();
		oldY = w.getY();
		
		
		
		
		}
	}
}
