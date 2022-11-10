
public class FileIOTest {
	public static void main(String args[]) throws Exception {    
		FileIO testFileIO = new FileIO();
		System.out.println("The longest word in the file is: " + testFileIO.findLongestWord("example.txt") + "\n");
		System.out.print("The lines in the file are:\n" + testFileIO.fileToArray("example.txt"));
	}     
}
