import java.util.ArrayList;

public class PayrollSystemTest {
	public static void main(String[] args) {

		ArrayList<Employee> listOfEmployees = new ArrayList<Employee>();
		listOfEmployees.add(new SalariedEmployee("John", "Smith", "111-11-1111", 800.0));
		listOfEmployees.add(new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40.00));
		listOfEmployees.add(new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000.00, 0.06));
		listOfEmployees.add(new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000.00, 0.04, 300.00));
		listOfEmployees.add(new PieceWorker("Rick", "Bridges", "555-55-5555", 2.25, 400));
		
		System.out.println("Employees processed polymorphically:\n");
		for (Employee e: listOfEmployees) {
			System.out.printf("%s%nearned $%.2f%n%n", e.toString(), e.earnings());
		}
	}
}
