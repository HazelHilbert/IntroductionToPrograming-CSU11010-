import java.util.ArrayList;

class Bank {
	private int accountNumber = 0;
	private String customerName = null;
	private String customerAddress = null;
	private int customerDateOfBirth = 0;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accNumber) {
		accountNumber = accNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String name) {
		customerName = name;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String address) {
		customerAddress = address;
	}

	public int getCustomerDateOfBirth() {
		return customerDateOfBirth;
	}

	public void setCustomerDateOfBirth(int dob) {
		customerDateOfBirth = dob;
	}

	public static String findCustomer(int accountNumber, Bank[] arr) {
		int i = 0;
		while(arr[i].getAccountNumber() != accountNumber) {
			i++;
		}
		return arr[i].getCustomerName();
	}

	public static String findCustomer(int customerDateOfBirth, String customerAddress, Bank[] arr) {
		int i = 0;
		while(!((arr[i].getCustomerDateOfBirth() == customerDateOfBirth) && (arr[i].getCustomerAddress() == customerAddress))) {
			i++;
		}
		return arr[i].getCustomerName();
	}
	
	public static String findCustomer(int accountNumber, ArrayList<Bank> arr) {
		 return arr.get(arr.indexOf(accountNumber)).getCustomerName();
	}

	public static void main(String[] args) {

		Bank[] bankCustomers = new Bank[10];
		for(int i=0; i<bankCustomers.length; i++)
			bankCustomers[i] = new Bank();

		bankCustomers[0].setAccountNumber(1345);
		bankCustomers[0].setCustomerAddress("blablabla");

		bankCustomers[5].setAccountNumber(5345);
		bankCustomers[5].setCustomerDateOfBirth(5082003);


		bankCustomers[6].setAccountNumber(12345);
		bankCustomers[6].setCustomerName("Hazel");
		bankCustomers[6].setCustomerDateOfBirth(5082003);
		bankCustomers[6].setCustomerAddress("blablabla");


		System.out.println("The name under account 12345 is " +  findCustomer(12345, bankCustomers));
		System.out.println("The name under the account with that adress and DOB is " + findCustomer(5082003,"blablabla", bankCustomers));
		
		
		ArrayList<Bank> bankList = new ArrayList<Bank>();
	}
}