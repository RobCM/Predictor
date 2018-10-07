package PredictorSoftware;

import java.io.IOException;
import java.util.Scanner;

/*
 *   Robert Coleman 9/16/2018
 *   This software helps the user choose the best lottery number to play!
 */
public class predictor_Main 
{
	// Global variables
	private static int n = 54, k = 6; // numbers on the Lotto
	private static Scanner num1;
	private static Scanner num2;
	private static Scanner num3;
	private static Scanner num4;
	private static Scanner num5;
	private static Scanner num6;
	
	// Just to display program's title
	public static void title()
	{
		System.out.println("========================================================");
		System.out.println("@@@@@@@  @@@@@@@   @@@@@@@@");
		System.out.println("@@   @@  @@  @@    @@@     ");
		System.out.println("@@@@@@@  @@@@      @@@@@@@@");
		System.out.println("@@@      @   @     @@@     ");
		System.out.println("@@@      @    @    @@@@@@@@ dictor");
		System.out.println("\t \t \t vertion 0.1");
		System.out.println("========================================================");
	}
   // The menu
	public static void proMenu() throws IOException
	{
		// Variable for input selection in the switch statement
		Scanner selectChoice = new Scanner(System.in); 
		System.out.println("What will you like to do?");
		System.out.println("1. for number probability");
		System.out.println("2. for Lotto drwing simulation");
		System.out.println("3. To exit");
		int inputNum = selectChoice.nextInt();
		
			switch(inputNum)
			{
			   case 1: Result();
			           break;
			   case 2: Simulation runSim = new Simulation();
			           runSim.runSim();
			           // Re-call function for menu
			    	   proMenu();
			           break;
			   case 3: // exit the program! 
				   System.exit(0);
				   break;
			   default:
				    // Error handling!
				   System.out.println(" \t ERROR! THAT IS NOT A GOOD INPUT.");
				   proMenu();
			}
		// Close the input for user
		selectChoice.close();		
	}
	
   // Using binomial coefficient formula for out come of the prediction!
   public static int binomialFormula(int n, int k)  
   {
	   // The base cases 
       if (k == 0 || k == n) 
       {
    	   return 1; 
       }         
       // The recurrence 
       return binomialFormula(n - 1, k - 1) + binomialFormula(n - 1, k); 
   }
   // Display the calculation
   public static void Result() throws IOException
   { 
	   
	   
	   System.out.println("Possibilities of number combinations: " + binomialFormula(n, k));// Using the binomial function
	   // User Lotto numbers input
	   System.out.println("Enter your lottery numbers (6 numbers! without repeating them)");
	   
	    num1 = new Scanner(System.in);
	    System.out.println("Number 1: "); 
	    // Making sure input is not char or letter!
	    while(!num1.hasNextInt())
	    {
	        num1.next();
	        errorInput();
	    }   
	    int numOne = num1.nextInt();
	    
	    num2 = new Scanner(System.in);
	    System.out.println("Number 2: "); 
	    while(!num2.hasNextInt())
	    {
	        num2.next();
	        errorInput();
	    }  
	    int numTwo = num2.nextInt();
	    
	    num3 = new Scanner(System.in);
	    System.out.println("Number 3: "); 
	    while(!num3.hasNextInt())
	    {
	        num3.next();
	        errorInput();
	    }  
	    int numThree = num3.nextInt();
	    
	    num4 = new Scanner(System.in);
	    System.out.println("Number 4: "); 
	    while(!num4.hasNextInt())
	    {
	        num4.next();
	        errorInput();
	    }  
	    int numFour = num4.nextInt();
	    
	    num5 = new Scanner(System.in);
	    System.out.println("Number 5: "); 
	    while(!num5.hasNextInt())
	    {
	        num5.next();
	        errorInput();
	    }  
	    int numFive = num5.nextInt();
	   
	    num6 = new Scanner(System.in);
	    System.out.println("Number 6: ");
	    while(!num6.hasNextInt())
	    {
	        num6.next();
	        errorInput();
	    }  
	    int numSix = num6.nextInt();
	   
	   double testNum1 = numOne;
	   double testNum2 = numTwo;
	   double testNum3 = numThree;
	   double testNum4 = numFour;
	   double testNum5 = numFive;
	   double testNum6 = numSix;
	   System.out.println("Your numbers and probability: ");
	   // Divide the total of combinations by the user's number
	   System.out.println("\t" + testNum1 + " has " + binomialFormula(n, k)/ testNum1 + " %");
	   System.out.println("\t" + testNum2 + " has " + binomialFormula(n, k)/ testNum2 + " %");
	   System.out.println("\t" + testNum3 + " has " + binomialFormula(n, k)/ testNum3 + " %");
	   System.out.println("\t" + testNum4 + " has " + binomialFormula(n, k)/ testNum4 + " %");
	   System.out.println("\t" + testNum5 + " has " + binomialFormula(n, k)/ testNum5 + " %");
	   System.out.println("\t" + testNum6 + " has " + binomialFormula(n, k)/ testNum6 + " %");	   
	   
	   // Re-call function for menu
	   proMenu();
   }
    // Function for error display
   public static void errorInput()
   {
	   System.out.println("Input most be a number 1 to 54!");
   }
    
	// Main calling functions
	public static void main(String[] args) throws IOException 
	{		
	   title();
	   proMenu();
    }
}