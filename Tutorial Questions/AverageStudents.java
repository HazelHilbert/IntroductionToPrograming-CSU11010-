import java.util.Scanner;

public class AverageStudents {
	
	public static final int NUMBER_OF_STUDENTS = 5;
	
	public static double determineAverageMark(double[] marks) {
		double sum = 0.0;
		for (int student = 0; student < marks.length; student++) 
			sum += marks[student];
		return (sum / marks.length);
	}
	
	public static int countAboveAverageStudents(double[] marks) {
		double average = determineAverageMark(marks);
		int studentsAboveAverge = 0;
		for (int student = 0; student < marks.length; student++) 
			if (marks[student] > average)
				studentsAboveAverge++;
		return studentsAboveAverge;
	}
	
	public static void main(String[] args) {	
		Scanner input = new Scanner(System.in);
		double[] listOfStudentScores = new double[NUMBER_OF_STUDENTS];
				
		for (int student = 0; student < NUMBER_OF_STUDENTS; student++) 
		{
			System.out.printf("Enter the score of student %d: ", student + 1);
			listOfStudentScores[student] = input.nextDouble();
		}
		
		int aboveAverageStudents = countAboveAverageStudents(listOfStudentScores);
		System.out.printf("The average percentage is %.1f%% and there " +  
				((aboveAverageStudents == 1) ? "is only %d above average student" :
					"are %d above average students"),
				determineAverageMark(listOfStudentScores), aboveAverageStudents);
		
		input.close();
	}
}
