import java.io.*;
import java.util.ArrayList;

public class FileIO {
	public String findLongestWord(String fileName) throws Exception {
		FileReader fr = new FileReader(fileName);    
		BufferedReader br = new BufferedReader(fr);    

		String longestWord = "";
		String word = "";
		int longestCount = 0;
		int count = 0;
		int i;    
		while((i=br.read())!=-1) {  
			if ((char)i == ' ') {
				if (count > longestCount) {
					longestWord = word; 
					longestCount = count;
				}
				count = 0; 
				word = "";
			}
			else {
				count++;
				word += (char)i;
			}
		}

		br.close(); fr.close();  
		return longestWord;
	}

	public ArrayList<String> fileToArray(String fileName) throws Exception {
		FileReader fr = new FileReader(fileName);    
		BufferedReader br = new BufferedReader(fr);

		ArrayList<String> list = new ArrayList<String>();
		String line;
		while((line=br.readLine()) != null) list.add(line);

		br.close(); fr.close(); 
		return list;
	}
}
