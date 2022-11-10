import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineBookStore
{
	public static int ISBN_INDEX = 0;
	public static int TITLE_INDEX = 1;
	public static int AUTHOR_INDEX = 2;
	public static int PUBLISHER_INDEX = 3;
	public static int PUBLISHER_YEAR_INDEX = 4;
	public static int QUANTITY_INDEX = 5;
	public static int PRICE_INDEX = 6;

	public static void printBookDetails(ArrayList<Book> bookList) {
		for (int index = 0; index < bookList.size(); index++) {
			System.out.print(bookList.get(index).toString());
		}
	}

	public static Book getBook(ArrayList<Book> bookList, String title) {
		for (int index = 0; index < bookList.size(); index++) {
			if (bookList.get(index).getTitle().equalsIgnoreCase(title)) {
				return bookList.get(index);
			}
		}
		return null;
	}

	public static void topUpCard(ChargeCard card, double amount) {
		card.topUpFunds(amount);
	}

	public static void purchaseBook(ArrayList<Book> bookList) {
		Scanner input = new Scanner(System.in);
		Boolean quit = false;

		System.out.print("Enter the funds for your card: ");
		ChargeCard userCard = new ChargeCard();
		if (input.hasNextDouble()) {
			topUpCard(userCard, input.nextDouble());
		}
		else {
			System.out.print("Invalid funds");
			quit = true;
		}
		input.nextLine();
		
		while(!quit) {
			System.out.print("Enter the book title you would like to purchase (or quit): ");
			String bookTitle = input.nextLine();
			if (bookTitle.equalsIgnoreCase("quit")) quit = true;
			else {
				Book book = getBook(bookList, bookTitle);
				if (book == null)
					System.out.println("Sorry we do not have that book");
				else {
					if (book.getQuantity() < 1)
						System.out.println("Sorry that book is out of stock");
					else if (book.getPrice() > userCard.getFunds())
						System.out.println("Sorry you do not have enough funds to purchase that book. Funds: " + userCard.getFunds());
					else {
						book.setQuantity(book.getQuantity() - 1);
						userCard.removeFunds(book.getPrice());
						System.out.println("You have purchased: " + book.getTitle() + ". Funds: " + userCard.getFunds());
					}
				}
			}
		}
		input.close();
	}
	
	public static void main(String[] args)
	{
		ArrayList<Book> bookList = new ArrayList<Book>();
		try
		{
			FileReader fileReader = new FileReader("books.txt");// Enter the entire path of the file if needed
			BufferedReader bufferedReader = new BufferedReader(fileReader);  
			boolean endOfFile = false;

			while(!endOfFile)
			{
				String bookLine = bufferedReader.readLine();
				if (bookLine != null)
				{
					String[] bookData = bookLine.split(", ");
					String isbn = bookData[ISBN_INDEX];
					String title = bookData[TITLE_INDEX];
					String author = bookData[AUTHOR_INDEX];
					String publisher = bookData[PUBLISHER_INDEX];
					int publishYear = Integer.parseInt (bookData[PUBLISHER_YEAR_INDEX]);
					int quantity = Integer.parseInt (bookData[QUANTITY_INDEX]);
					double price = Double.parseDouble (bookData[PRICE_INDEX]);
					Book book = new Book(isbn, title, author, publisher, publishYear, quantity, price);
					bookList.add(book);

				}
				else
				{
					endOfFile = true;
				}
			}
			bufferedReader.close();    
			fileReader.close();
		} // End try 

		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		// Uncomment the following lines once you have implemented the required methods
		printBookDetails(bookList);
		purchaseBook(bookList);
	}
}