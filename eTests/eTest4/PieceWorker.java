
public class PieceWorker extends Employee {

	private double wage;
	private int pieces;

	public PieceWorker(String firstName, String lastName, String socialSecurityNumber, double wage, int pieces) {
		super(firstName, lastName, socialSecurityNumber);
		if (wage < 0.0)
			throw new IllegalArgumentException("Wage must be >= 0.0");
		if (pieces < 0)
			throw new IllegalArgumentException("Pieces produced must be >= 0");
		this.wage = wage;
		this.pieces = pieces;
	}
	
	public double getWage() {
		return wage;
	}
	
	public int getPieces() {
		return pieces;
	}
	
	public void setWage(double newWage) {
		wage = newWage;
	}
	
	public void setPieces(int newPieces) {
		pieces = newPieces;
	}

	@Override
	public double earnings() {
		return (wage * pieces);
	}

	@Override
	public String toString() {                                                                   
		return "piece worker: " + super.toString() + "\nwage per piece: $" + getWage() + "; pieces produced: " + getPieces();                         
	} 
}
