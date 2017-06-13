import java.util.ArrayList;
import java.util.Scanner;

public class GPAcalcMenlo 
{

	public static void main(String[] args) 
	{
		//create scanner
		Scanner console = new Scanner(System.in);
		
		ArrayList<String> Grades = new ArrayList<String>();
		ArrayList<Boolean> Status = new ArrayList<Boolean>();
		
		boolean done = false;
		while(!done)
		{
			System.out.println("Please enter your grade (or 0 if done)");
			String currentGrade = console.nextLine();
			if(currentGrade.equals("0"))
			{
				done = true;
			}
			else
			{
				Grades.add(currentGrade);
				
				System.out.println("Was that class an honors or AP Class? (y/n)");
				String currentStatus = console.nextLine();
				Boolean Honors;
				if(currentStatus.substring(0, 1).toLowerCase().equals("y"))
				{
					Honors = true;
				}
				else
				{
					Honors = false;
				}
				Status.add(Honors);
			}
		}
		System.out.println("Your GPA is: " + calculateGPA(Grades, Status));
	}
	
	public static double calculateGPA(ArrayList<String> Grades, ArrayList<Boolean> Status)
	{
		double GPA;
		double scoreSum = 0;
		double classCount = 0;
		
		for(String Grade : Grades)
		{
			scoreSum = scoreSum + convert(Grade);
			classCount++;
		}
		
		double amountOfBoost = 0;
		for(Boolean Honors : Status)
		{
			if(Honors)
			{
				amountOfBoost+=0.3;
			}
		}
		
		scoreSum+=amountOfBoost;
		
		GPA = scoreSum/classCount;
		return GPA;
	}
	
	public static double convert(String Grade)
	{
		double value;
		
		if(Grade.equals("A"))
		{
			value = 4.0;
		}
		else if(Grade.equals("A-"))
		{
			value = 3.67;
		}
		else if(Grade.equals("B+"))
		{
			value = 3.33;
		}
		else if(Grade.equals("B"))
		{
			value = 3.0;
		}
		else if(Grade.equals("B-"))
		{
			value = 2.67;
		}
		else if(Grade.equals("C+"))
		{
			value = 2.33;
		}
		else if(Grade.equals("C"))
		{
			value = 2.0;
		}
		else
		{
			value = 1.67;
		}
		return value;
	}

}
