package RecursionReturnExample;

public class ReturnDataAndObjectExample {

	public static void main(String[] args) {
		System.out.println(getMessage("Hello", 5));
		
		System.out.println(getSumInt(4)); //Returns the sum from 1 to 4
		
		System.out.println(getInt(4));	//Will always be 1
		
		getIntegersFrom(5);
		
		System.out.println("\nGetNextInt(4) with helper: " + getNextInt(4));
	}
	
	public static String getMessage(String m, int count) { //Limit This
		if(count <= 1) {
			return m;
		}else {
			return m + " " + getMessage(m, count - 1);	//Add the message m to the next one
		}
	}

	public static int getSumInt(int n) {
		if(n == 0) {
			return n;
		}else {
			return n + getSumInt(n - 1);
		}
	}
	
	public static int getInt(int n) {
		if(n == 1) {
			return n;
		}else {
			return getInt(n - 1);
		}
	}
	
	public static void getIntegersFrom(int n) {
		if(n >= 1) {
			System.out.print(n + " ");
			getIntegersFrom(n - 1);
		}
	}

	//Example of Linear Recursion: printing hello n times
	public static void RecursiveHello(int n) {
		if(n < 1) {								// Base Case: If n reaches zero, return will
			return;					// NOTE: The return statement is used here to ensure that once this condition is met, the following 
									//		statements of code will not execute, therefore, terminating the program
		}else {
			System.out.println("Hello");
			RecursiveHello(n - 1);
		}
	}
	
	public static int getNextInt(int n) {

		if(n < 1) {
			return n;
		}else {
			return getNextIntHelper(n, n - 1);
		}
	}	
	public static int getNextIntHelper(int n, int next) {
		if(next > n) {
			return next;
		}else {
			return getNextIntHelper(n, next + 1);
		}
	}
}

