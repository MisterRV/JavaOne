import java.util.Random;

public class LotteryDrawing extends Lotto {
	
	private static int[] results = new int[numberOfBalls+1];
	
	public static void setResults(int right){
		results[right]++;
	}

	public static int[] getResult(){
		return results;
	}
	
	public static void run_simulation(){
		//Creating 2 instances of Lotto each with an array of -p nr of balls
		Lotto myGuess = new Lotto();
		Lotto winningGuess = new Lotto();

		//Array of guessed Numbers
		myGuess.balls = pick_numbers(numberOfBalls, maxLottoNumber);
		
		//Array's of drawing looping numberOfDraws
		for(int draws = 0; draws < numberOfDraws; draws++){
			winningGuess.balls = pick_numbers(numberOfBalls, maxLottoNumber);
			int right=0;
			for(int i = 0; i < numberOfBalls ; i++ ){
				for(int x = 0; x < numberOfBalls ; x++){
					if (myGuess.balls[i] == winningGuess.balls[x]){
						right++;
					}
				}
			}
			setResults(right);	
		}
	}
	
	private static int[] pick_numbers(int numberOfBalls, int maxLottoNumber){
		int[] lotto = new int[numberOfBalls];
		for(int i = 0; i < numberOfBalls; i++){
			lotto[i] = lotto_ball_getter(maxLottoNumber);
			for(int x = 0; x < i ; x++){
				while(lotto[i] == lotto[x]){
					lotto[i] = lotto_ball_getter(maxLottoNumber);
					x = 0;
					}
				}
			}
		return lotto;
	}

	private static int lotto_ball_getter(int max) {
		int randomNum;
		Random rand = new Random();

		//Add 1 to make the result maxNumber inclusive and avoid getting a 0
		randomNum = rand.nextInt(max) + 1 ;
		return randomNum;
	}

	public static void print_results() {
		System.out.println();
		System.out.println("\t--Lottery Drawing Report--");
		System.out.format("\tMatches\tCount\tPercent\n");
		float[] resultPercent = new float[numberOfBalls+1];
		// Calculating the percentage and put it in a float array
		for(int i = 0; i < getResult().length; i++){
			resultPercent[i] = ((float) getResult()[i] / ((float)numberOfDraws/100) );
		}
		for(int i = 0; i < getResult().length; i++){
	        System.out.format("\t%5d\t %4d\t %6.2f\n", i, getResult()[i], resultPercent[i]);
		}
		
	}
}

