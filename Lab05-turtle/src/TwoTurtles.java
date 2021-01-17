import se.lth.cs.pt.window.SimpleWindow;
import java.util.Random;

public class TwoTurtles {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleRandom");
		Turtle ett = new Turtle(w, 250, 250);
		Turtle två = new Turtle(w, 350, 350);
		Random stegl = new Random();
		Random vrid = new Random();
		ett.penDown();
		två.penDown();
		while (Math.sqrt(((ett.getX()-två.getX())*(ett.getX()-två.getX()) + (ett.getY() - två.getY())*(ett.getY() - två.getY()))) >= 50) {
			int s = stegl.nextInt(10);
			s += 1;
			int v = stegl.nextInt(10);
			s += 1;
			int l = vrid.nextInt(360);
			l -= 180;
			int p = vrid.nextInt(360);
			l -= 180;
			ett.forward(s);
			ett.left(l);
			två.forward(v);
			två.left(p);
			SimpleWindow.delay(10);
		}
	}
}
