package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num_customers = scan.nextInt();
		
		String[] first_names = new String[num_customers];
		String[] last_names = new String[num_customers];
		double[] totals = new double[num_customers];
		

		// For each customer, multiply number of items by cost of each item and add to customer's total spent
		for (int i=0; i < num_customers; i++) {
			first_names[i] = scan.next();
			last_names[i] = scan.next();
			int num_items = scan.nextInt();
			for (int j=0; j < num_items; j++) {
				int item_count = scan.nextInt();
				scan.next(); // skip over product name
				double item_cost = scan.nextDouble();
				totals[i] += item_count * item_cost;
			}
		}
		
		// Print in the form F. LAST: TOTAL
		for (int n=0; n < num_customers; n++) {
			System.out.printf("%s. %s: %.2f%n", first_names[n].substring(0, 1), last_names[n], totals[n]);
		}

		scan.close(); // close scanner
	}
	
}
