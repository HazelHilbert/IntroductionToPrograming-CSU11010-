import java.io.*;
import java.util.Scanner;

public class FilesAndStreamsTutorial {
	public static void toDocument(FileWriter fw) throws Exception {
		//FileReader fr = new FileReader("textFile.txt");    
		//BufferedReader br = new BufferedReader(fr);  
		BufferedWriter bw = new BufferedWriter(fw);
		Scanner input = new Scanner(System.in);

		boolean quit = false;
		while(!quit) {
			System.out.print("enter a word (or 'quit')> ");
			String word = input.next();
			if(word != null && !word.equalsIgnoreCase("quit")) {
				bw.write(word + " ");
				bw.flush();
			}
			else
				quit = true;
		}
		System.out.print("Success");
		input.close();
		bw.close();
		fw.close();
	}
	public static void main(String args[]) throws Exception {
		FileWriter fw = new FileWriter("textFile.txt");
		toDocument(fw);
	}
}
