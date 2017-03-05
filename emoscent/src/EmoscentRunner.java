import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EmoscentRunner {
	static String[] sadToHappy = {"blueberry" , "lemon"};
	static String[] calmToAngry = {"chocolate" , "flowers"};
	static ArrayList<Integer> blueberry = new ArrayList<Integer>();
	static List<Integer> lemon = new ArrayList<Integer>();
	static List<Integer> chocolate = new ArrayList<Integer>();
	static List<Integer> flowers = new ArrayList<Integer>();
	static int happyCounter = 0;
	static int angryCounter = 0;
	static int GREEN = 1;
	static int AQUA = 2;
	static int BLUE = 10;
	static int PURPLE = 11;
	static int MAGENTA = 3;
	static int WHITE = 4;
	static final long RECORD_TIME = 5000;
	static String pythonCall = "python /Users/heos/Downloads/OpenVokaturi-2-1b/examples/measure_wav_mac.py";
	static String angry1 = "/Users/heos/Downloads/sample1angry.wav";
	static String neutral1 = "/Users/heos/Downloads/sample1neutral.wav";
	static String angry2 = "/Users/heos/Downloads/sample2angry.wav";
	static String angry4 = "/Users/heos/Downloads/sample4angry.wav";
	static String[][] DIRECTORY1 = {
			{angry1, angry2},
			{neutral1, neutral1}
	};
	static String[][] DIRECTORY2 = {
			{angry1, angry4},
			{angry2, angry2}
	};
	static int dataCounter = 0;
	static int counter1 = 0;
	static int[][] data = new int[2][4];
	static String calibratedScent;
	public static void main(String[] args) throws IOException, InterruptedException {

	

		blueberry.add(106);
		blueberry.add(130);
		blueberry.add(192);
		blueberry.add(164);
		blueberry.add(187);
		blueberry.add(137);
		blueberry.add(155);
		blueberry.add(179);
		blueberry.add(105);
		lemon.add(134);
		lemon.add(156);
		lemon.add(192);
		lemon.add(156);
		lemon.add(189);
		lemon.add(113);
		lemon.add(203);
		lemon.add(201);
		lemon.add(203);
		lemon.add(152);
		
		final JavaSoundRecorder recorder = new JavaSoundRecorder();
		
		Febreze x = new Febreze();
		x.changeColor(WHITE);
		System.out.println("> [EMOSCENT] "+ "Default LED Color WHITE");
		record(recorder);
		Vokaturi vokaturi = new Vokaturi();

			
		Runtime.getRuntime().exec(pythonCall);
		Thread.sleep(1000);
		getFeelingScores(vokaturi, x);
		
		
		
		
	}

	public static void getFeelingScores(Vokaturi vokaturi, Febreze x) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

			vokaturi.read();
			vokaturi.printOut();
			

			
			if(dataCounter == 11){
				if(averageOfArrayList(blueberry) > averageOfArrayList(lemon)){
					
				}
			}
			else if(vokaturi.getAngerScore() > 5){
				x.changeColor(MAGENTA); //replaces changing scent
				//Febreze.spray(calmToAngry[1]);
				analyzeData((int) vokaturi.getAngerScore() + 1, "flowers", vokaturi);
				angryCounter++;
				counter1--;
			}
			else if(vokaturi.getAngerScore() > 5 || vokaturi.getDisgustScore() > 10){
				//Febreze.spray(calmToAngry[0]);
				x.changeColor(MAGENTA);
				analyzeData((int) vokaturi.getHappinessScore() + 1, "chocolate", vokaturi);
				angryCounter++;
			}
			else if(vokaturi.getHappinessScore() < 50){
				//Febreze.spray(sadToHappy[0]);
				x.changeColor(GREEN);
				analyzeData((int) vokaturi.getHappinessScore() + 1, "blueberry", vokaturi);
				happyCounter++;
				counter1++;
			} 	
			else{
				if(vokaturi.getHappinessScore() < 50){
					//Febreze.spray(sadToHappy[1]);
					x.changeColor(GREEN);
					analyzeData((int) vokaturi.getHappinessScore() + 1, "lemon", vokaturi);
					System.out.println("> [EMOSCENT] " +"Happiness is below fifty! Spraying Lemon. (Changing LED to White)");
					happyCounter++;
					counter1++;
			}
			}

			
	
	
		
	
	
	dataCounter++;
		
	if(blueberry.size() > 9){
		System.out.println("> [EMOSCENT] Final Calibration Score for Blueberry over Ten Tries: " + averageOfArrayList(blueberry));
		
	}
	
	if(lemon.size() > 9){
		System.out.println("> [EMOSCENT] Final Calibration Score for Lemon over Ten Tries: " + averageOfArrayList(lemon));
	}
	
	if(averageOfArrayList(blueberry) < averageOfArrayList(lemon)){
		System.out.println("> [EMOSCENT] Lemon is overall more effective for user x. Using this scent from now on to go from sad -> happy");
	}
	

			
		
			Thread.sleep(2000);
			//TimeUnit.MINUTES.sleep(3);
		
			//run main() 10 times
			
			/*while(true){
				
			if(vokaturi.getHappinessScore() < 50){
			sprayHappyScent();
			}
			else if(vokaturi.getAngerScore() > 20){
			sprayCalmingScent();
			}
			
			//TimeUnit.MINUTES.sleep(3);
			Thread.sleep(2000);
			}*/
	}


	private static void sprayCalmingScent() {
		// TODO Auto-generated method stub
		if(averageOfArrayList(chocolate) > averageOfArrayList(flowers)){
			//Febreze.spray("chocolate");
		} else {
			//Febreze.spray("flowers");
		}
	}

	private static void sprayHappyScent() {
		// TODO Auto-generated method stub
		
		if(averageOfArrayList(blueberry) > averageOfArrayList(lemon) && blueberry.size() > 10 && lemon.size() > 10){
			System.out.println("> [EMOSCENT] Calibrated Scent is BlueBerry!");
			calibratedScent = "blueberry";
		} else if(averageOfArrayList(blueberry) < averageOfArrayList(lemon) && blueberry.size() > 10 && lemon.size() > 10){
			System.out.println("> [EMOSCENT] Calibrated Scent is Lemon!");
			calibratedScent = "lemon";
		}

		
	}

	private static void analyzeData(int score, String scent, Vokaturi v) throws IOException {
		// TODO Auto-generated method stub
		int difference = (int) (score - v.getHappinessScore());
		int percentFactor = (difference/score) * 100;
		if(scent == "blueberry"){
			blueberry.add(percentFactor);
			System.out.println("> [EMOSCENT] Average Blueberry Percentage Factor " + averageOfArrayList(blueberry));
		}
		else if(scent == "lemon"){
			lemon.add(percentFactor);
			System.out.println("> [EMOSCENT] Average Lemon Percentage Factor" + averageOfArrayList(blueberry));
		}
		else if(scent == "chocolate"){
			chocolate.add(percentFactor);
			System.out.println("> [EMOSCENT] Average Chocolate Percentage Factor " + averageOfArrayList(blueberry));
		}
		else if(scent == "flowers"){
			flowers.add(percentFactor);
			System.out.println("> [EMOSCENT] Average Flowers Percentage Factor " + averageOfArrayList(blueberry));
		}

	}	
	
	public static double averageOfArrayList(List<Integer> x){
		int n = 0;
		for(int i = 0; i < x.size(); i++){
			n += x.get(i);
		}
	if(x.size() ==  0){
		return n / 1;
	}
	else
		return n / x.size(); 

	}
	  public static void record(JavaSoundRecorder z){
	    	// creates a new thread that waits for a specified
			// of time before stopping
			Thread stopper = new Thread(new Runnable() {
			        public void run() {
			            try {
			                Thread.sleep(RECORD_TIME);
			            } catch (InterruptedException ex) {
			                ex.printStackTrace();
			            }
			            z.finish();
			        }
			    });
			
			stopper.start();
 		
			// start recording
			z.start();
	    	
	
}}

	
	
//Chat Conversation End
