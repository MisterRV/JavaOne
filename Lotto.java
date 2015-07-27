public class Lotto {

	static long startTime = System.currentTimeMillis();
	static int numberOfBalls = 6;
	static int maxLottoNumber = 54;
	static int numberOfYears = 1;

	static int numberOfDraws = numberOfYears * 104;
	
	int[] rightGuess = new int[numberOfBalls+1];
	int[] balls = new int[numberOfBalls];

	public Lotto(){
	}
	
	public static void main(String[] args) {
//	    A flag -b followed by an integer number of lotto balls to use (default is 6)
//	    A flag -p followed by the maximum ball number i.e. from 1 to the max (default is 54)
//	    A flag -y followed by the number of years to simulate (default is 1)
		for(int i = 0; i < args.length; i = i + 2) {
			if(args[i].equals("-b")){
				try { 
					numberOfBalls = Integer.parseInt(args[i+1]);
				} catch (NumberFormatException e){
					
				}
			} else if(args[i].equals("-p")){
				try {
				maxLottoNumber = Integer.parseInt(args[i+1]);
				} catch (NumberFormatException e){
					
				}
			} else if(args[i].equals("-y")){
				try {
				numberOfDraws = Integer.parseInt(args[i+1]) * 104;
			} catch (NumberFormatException e){
				
				}
			}
		}	
		
		
//		Make sure there are more ball in the game then the number of balls being drawn
		if(maxLottoNumber < numberOfBalls){
			System.out.println("Unable to draw " + numberOfBalls + " from a batch of only " + maxLottoNumber + " balls");
		} else {
			calc_odds(numberOfBalls, maxLottoNumber);
			LotteryDrawing.run_simulation();
			LotteryDrawing.print_results();
		}
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		System.out.println();
		System.out.println("Runtime: " + totalTime/1000 + "." + totalTime%1000 + " Seconds");	

	}

	private static void calc_odds(int numberOfBalls, int maxLottoNumber) {
		long odds = 1;
		for(int i = maxLottoNumber; i > maxLottoNumber - numberOfBalls ; i--){
			odds = odds * i; 
		}
			System.out.println("The Odd of winning are: 1 in " + odds + " by drawing " + numberOfBalls + " balls out of a set of " + maxLottoNumber);
	}
}
