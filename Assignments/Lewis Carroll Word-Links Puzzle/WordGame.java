/* SELF ASSESSMENT 
1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment: yes it returns a ArrayList of type String
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment: yes it does using a buffered reader
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: yes it returns a ArrayList of the words in the filee

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment: yes I do
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: yes, I do so by first putting it into a String array and then copying it to an ArrayList

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment: yes
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: yes, and it does so without repeating comparisons
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment: yes it will exit the loop by returning false
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: yes

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: I do
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:2]
- Comment: it uses a binarySearch method of the Collections class
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: yes it does that

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: I do
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: yes it does

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: yes
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: yes it calls all of those methods

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: yes it does that
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: yes the user is asked for input and isWordChain is called until an empty list is entered

 Total Mark out of 100 (Add all the previous marks): 99
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordGame {

	public static ArrayList<String> dictionary = new ArrayList<String>();

	public static ArrayList<String> readDictionary() throws Exception {
		FileReader fr = new FileReader("words.txt");    
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> dict = new ArrayList<String>();
		String word;
		while((word=br.readLine()) != null) dict.add(word);
		br.close(); fr.close();
		dictionary = dict;
		return dict;
	}

	public static ArrayList<String> readWordList(Scanner input){
		ArrayList<String> arrayOfWords = new ArrayList<String>();
		String[] words = input.nextLine().split("\\s*,\\s*");   
		for (int i = 0; i < words.length; i++)
			arrayOfWords.add(words[i]);
		return arrayOfWords;
	}

	public static boolean isUniqueList(ArrayList<String> arrayOfWords) {
		for (int i = 0; i < arrayOfWords.size(); i++) {
			for (int j = i+1; j < arrayOfWords.size(); j++)
				if (arrayOfWords.get(i).equalsIgnoreCase(arrayOfWords.get(j))) return false;
		}
		return true;
	}

	public static boolean isEnglishWord(String word) {
		return 0 < Collections.binarySearch(dictionary, word);
	}

	public static boolean isDifferentByOne(String word1, String word2){
		if (word1.length() != word2.length()) return false;
		int difrences = 0;
		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i)) difrences++;
		}
		return (difrences == 1) ? true : false;
	}

	public static boolean isWordChain(ArrayList<String> arrayOfWords) {
		if (!isUniqueList(arrayOfWords)) return false;
		if (!isEnglishWord(arrayOfWords.get(0))) return false;
		for (int i = 0; i < arrayOfWords.size()-1; i++) {
			if (!isEnglishWord(arrayOfWords.get(i+1))) return false;
			if (!isDifferentByOne(arrayOfWords.get(i), arrayOfWords.get(i+1))) return false;
		}
		return true;
	}

	public static void main(String args[]) throws Exception {
		readDictionary();
		Scanner input = new Scanner(System.in);
		boolean quit = false;
		while(!quit) {
			System.out.print("Enter a comma separated list of words (or an empty list to quit): ");
			ArrayList<String> listOfWords = readWordList(input);
			if (listOfWords.size() == 1 && listOfWords.get(0).equals("")) quit = true;
			else System.out.println((isWordChain(listOfWords)) ? "Valid chain of words from Lewis Carroll's word-links game." : 
					"Not a valid chain of words from Lewis Carroll's word-links game.");
		}
	}
}