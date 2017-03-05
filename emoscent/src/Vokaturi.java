import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Vokaturi{
	String line;

	public Vokaturi() throws IOException {
		try {
			read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void read() throws IOException {
		FileReader fr = new FileReader("Emotions.txt");
		BufferedReader br = new BufferedReader(fr);
		
		line = br.readLine();
		
	}
	
	public void printOut() throws IOException {
		System.out.println("> [EMOSCENT] "  + "Neutral: "+ Double.parseDouble(line.substring(0,5)) * 100 + " "+ "Happiness: " + Double.parseDouble(line.substring(7, 12)) * 100+ " " + "Sadness: " + Double.parseDouble(line.substring(14,19)) * 100 + " "+ "Anger: " + Double.parseDouble(line.substring(21, 26)) * 100 + " "+ "Disgust: " +Double.parseDouble(line.substring(28, 33)) * 100);
	}
	
	public double getHappinessScore() throws IOException {
		//System.out.println("happiness score" + Double.parseDouble(line.substring(7, 12)) * 100);
		return(Double.parseDouble(line.substring(7, 12)) * 100);
		
	}
	
	public double getAngerScore() throws IOException {
		//System.out.println("anger score" + Double.parseDouble(line.substring(21, 26)) * 100);
		
		return(Double.parseDouble(line.substring(21, 26)) * 100);
		
	}
	public double getDisgustScore() throws IOException {
		//System.out.println("anger score" + Double.parseDouble(line.substring(21, 26)) * 100);
		
		return(Double.parseDouble(line.substring(28, 33)) * 100);
		
	}
	

}
