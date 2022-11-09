import java.util.Scanner;

public class triangle {
	public static void main(String[] args) {
		// imput 3 points		
		System.out.print("Ax: ");
		Scanner imput = new Scanner( System.in );	
		Double aX = imput.nextDouble();
				
		System.out.print("Ay: ");
		Double aY = imput.nextDouble();
		
		System.out.print("Bx: ");
		Double bX = imput.nextDouble();
		
		System.out.print("By: ");
		Double bY = imput.nextDouble();
		
		System.out.print("Cx: ");
		Double cX = imput.nextDouble();
		
		System.out.print("Cy: ");
		Double cY = imput.nextDouble();
		imput.close();
				
		//Area according to given formula
		double area = Math.abs((aX * (bY - cY) + bX * (cY - aY) 
					  + cX * (aY - bY)) / 2);
			
		//Print Area
		System.out.printf("The area of the triangle defined by these three points is: %.2f", area);
		//test: (12, 2.0), (-13, 5), (8, 16) should give 169.0

	}
}
