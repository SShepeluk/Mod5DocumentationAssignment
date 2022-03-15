//Sharlton Shepeluk



import java.util.*;

public class main {

	//Recursive Fibonacci Thread ================================================
	public static class recursiveFib extends Thread {
		public int n = 20; //Fibonacci calculates up to this number
		public int answer;
		private long startTime = System.nanoTime(); 
		private long endTime;

		public int rFib(int n) {

			if (n <= 1)
				return n;

			return rFib(n - 1) + rFib(n - 2);
		}

		public void run() {
			answer = rFib(n);

			endTime = System.nanoTime() - startTime;
			System.out.println("Recursive Input: " + n);
			System.out.println("Recursive thread found the answer: " + answer + " in " + endTime + "ns");
			
		
		}

	}
	
	//Iterative Fibonacci Thread ===================================================
	public static class iterativeFib extends Thread{
		public int n = 20; //Fibonacci calculates up to this number
		public int answer;
		private long startTime = System.nanoTime(); 
		private long endTime;
		public int v1 = 0;
		public int v2 = 1;
		public int v3 = 0;

		
		public int iFib(int n) {
			for(int i = 2; i <= n; i++) {
				v3 = v1 + v2;
				v1 = v2;
				v2 = v3;
			}
			return v3;
			
		}
		public void run() {
			answer = iFib(n);

			endTime = System.nanoTime() - startTime;
			System.out.println("Iterative Input: " + n);
			System.out.println("Iterative thread found the answer: " + answer + " in " + endTime + "ns");
		}
		
		
		
		
	}

	//Main ======================================================================
	public static void main(String[] args) {
		
		
		
		(new recursiveFib()).start();
		(new iterativeFib()).start();
		
		
	}// end main

}