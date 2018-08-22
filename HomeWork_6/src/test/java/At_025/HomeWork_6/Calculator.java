package At_025.HomeWork_6;

import java.util.Scanner;

public class Calculator {
	private static Scanner inp;



	public static void main(String[] args) {
		System.out.println("Enter first and second number:");
		inp = new Scanner(System.in);
		int num1, num2;
		num1 = inp.nextInt();
		num2 = inp.nextInt();

	
		System.out.println(
				"Enter your selection: 1 for Addition, 2 for substraction 3 for Multiplication and 4 for division:");
		int choose;
		choose = inp.nextInt();
		switch (choose) {
		case 1:
			System.out.println(add(num1, num2));
			break;
		case 2:
			System.out.println(sub(num1, num2));
			break;
		case 3:
			System.out.println(mult(num1, num2));
			break;
		case 4:
			System.out.println(div(num1, num2));
			break;
		default:
			System.out.println("Illigal Operation");

		}

	}

	public static int add(int x, int y) {
		int result = x + y;
		return result;
	}

	public static int sub(int x, int y) {
		int result = x - y;
		return result;
	}

	public static int mult(int x, int y) {
		int result = x * y;
		return result;
	}

	public static int div(int x, int y) {
		int result = x / y;
		return result;
	}
	 // Integer divide. Return a truncated int.
	   public static int divInt(int x, int y) {
	      if (y == 0) {
	         throw new IllegalArgumentException("Cannot divide by 0!");
	      }
	      return x / y;
	   }
	 
	   // Real number divide. Return a double.
	   public static double divReal(int x, int y) {
	      if (y == 0) {
	         throw new IllegalArgumentException("Cannot divide by 0!");
	      }
	      return (double) x / y;
	   }
}
