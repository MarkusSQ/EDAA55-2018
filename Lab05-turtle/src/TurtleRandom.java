import se.lth.cs.pt.window.SimpleWindow;
import java.util.Random;

public class TurtleRandom {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleRandom");
		Turtle t = new Turtle(w, 300, 300);
		Random stegl = new Random();
		Random vrid = new Random();
		t.penDown();
		for (int i = 0; i < 999; i++) {
			int s = stegl.nextInt(9);
			s += 1;
			int l = vrid.nextInt(359);
			l -= 180;
			t.forward(s);
			t.left(l);
			SimpleWindow.delay(100);
		}
	}

}
