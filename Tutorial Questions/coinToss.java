public class coinToss {
	public static void main(String[] args) {
		
		final int TOSSES = 10000; 
		int numberOfHeads = 0;
		int numberOfTails = 0;
		String headsOrTails = "";
		
		for (int counter = 0; counter < TOSSES; counter++) {
			if (Math.random() > 0.5) 
			{
				numberOfHeads++;
				headsOrTails = "heads";
			}
			else 
			{
				numberOfTails++;
				headsOrTails = "tails";
			}
		}
				
		System.out.printf("Heads: %d%n"
				+ "Tails: %d%n"
				+ "Last Toss: %s",
				numberOfHeads, numberOfTails, headsOrTails);
		
	}
}