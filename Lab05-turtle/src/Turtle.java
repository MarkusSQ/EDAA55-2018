import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	private SimpleWindow w;
	private boolean penna;
	private double x;
	private double y;
	private double direction = (Math.PI / 2);

	/** Skapar en sköldpadda som ritar i ritfönstret w. Från början 
	    befinner sig sköldpaddan i punkten x, y med pennan lyft och 
	    huvudet pekande rakt uppåt i fönstret (i negativ y-riktning). */
	public Turtle(SimpleWindow w, int x, int y) {
		penna = false;
		this.w = w;
		this.x = x;
		this.y = y;
	}

	/** Sänker pennan. */
	public void penDown() {
		penna = true;
	}
	
	/** Lyfter pennan. */
	public void penUp() {
		penna = false;
	}
	
	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		if (penna == true) {
			w.moveTo((int) Math.round(x), (int) Math.round(y));
			x += n * Math.cos(direction);
			y -= n * Math.sin(direction);
			w.lineTo((int) Math.round(x), (int) Math.round(y));
			
		} else {
			w.moveTo((int) Math.round(x), (int) Math.round(y));
			x += n * Math.cos(direction);
			y -= n * Math.sin(direction);
		}
	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		direction += beta * (Math.PI / 180);
	}

	/** Går till punkten newX, newY utan att rita. Pennans läge (sänkt
	    eller lyft) och huvudets riktning påverkas inte. */
	public void jumpTo(int newX, int newY) {
		w.moveTo(newX, newY);
		this.x = (newX);
		this.y = (newY);
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		direction = Math.PI / 2;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) Math.round(x);
	}

 	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) Math.round(y);
	}
  
	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
 	public int getDirection() {
 		return (int) Math.toDegrees(direction);
	}
}
