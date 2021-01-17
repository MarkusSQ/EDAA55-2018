public class Frågor {
	private static String f1 = "Hur gammalt är Rönninge Skola år 2019???????";
	private static String f2 = "Vad heter det gula huset som finns i centrum?";
	private static String f3 = "Vad heter fotbollsplanen närmast centrum?";
	private static String f4 = "Ligger Rönninge norr om Huddinge?";
	private static String f5 = "Vad heter gymnasiet som finns i Rönninge?";
	private static String f6 = "Finns det ett coop i centrum?";
	private static String f7 = "Heter centrums frisörsalong 'Good cut'?";
	private static String f8 = "Vad finns under hatten på tågstationen? En spindel eller en myra?";
	private static String f9 = "Rönninge har två sjöar. Den ena heter Flaten, vad heter den andra?";
	private static String f10 = "Vilken kommun är Rönninge del av?";
	
	
	public static String getf (int F) {
		if (F == 1) {
		return f1;
		}else if (F == 2) {
			return f2;
		}else if (F == 3) {
			return f3;
		}else if (F == 4) {
			return f4;
		}else if (F == 5) {
			return f5;
		}else if (F == 6) {
			return f6;
		}else if (F == 7) {
			return f7;
		}else if (F == 8) {
			return f8;
		}else if (F == 9) {
			return f9;
		}else  {
			return f10;
	}
	}
}