package a1;


// Allow use of hash map
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int num_items = scan.nextInt();
		Map<String, Double> prices = new HashMap<String, Double>(); // keeps track of price for each product
		
		// Add each product with corresponding price to hash map
		for (int i=0; i<num_items; i++) {
			prices.put(scan.next(), scan.nextDouble());
		}
		
		// Initialize array of customer names and amount spent by each customer
		int num_customers = scan.nextInt();
		String[] customer_names = new String[num_customers];
		double[] customer_expenditures = new double[num_customers];
		
		for (int j=0; j < num_customers; j++) {
			// Read in first and last name to customer name array
			String first_name = scan.next();
			String last_name = scan.next();
			customer_names[j] = first_name + " " + last_name;
			
			// Add up total amount spent by each customer (sum of products times corresponding product prices)
			int num_products = scan.nextInt();
			for (int k=0; k < num_products; k++) {
				int num_item = scan.nextInt();
				String product = scan.next();
				customer_expenditures[j] += num_item * prices.get(product);
			}
		}
		
		// Print biggest customer, smallest customer, and average spent by customers in the form
		// Biggest: First Last (spent)
		// Smallest: First Last (spent)
		// Average: average spent
		System.out.printf("Biggest: %s (%.2f)%n",
				           customer_names[indexOfMax(customer_expenditures)], 
				           customer_expenditures[indexOfMax(customer_expenditures)]);
		System.out.printf("Smallest: %s (%.2f)%n",
		                   customer_names[indexOfMin(customer_expenditures)],
		                   customer_expenditures[indexOfMin(customer_expenditures)]);
		System.out.printf("Average: %.2f%n", getAverage(customer_expenditures));
		
		scan.close();
	}
	
	/* indexOfMax 
	 * Gets index of largest value in array.
	 *
	 * Input: array of doubles
	 * 
	 * Output: integer index of the first occurrence of largest value in array
	 * 
	 * Preconditions:
	 * Input array must not be empty, or else will return 0.
	 */
	static int indexOfMax(double[] arr) {
		int max_idx = 0;
		for (int i=1; i < arr.length; i++) {
			if (arr[i] > arr[max_idx]) {
				max_idx = i;
			}
		}
		return max_idx;
	}
	
	/* indexOfMin
	 * Gets index of smallest value in array.
	 *
	 * Input: array of doubles
	 * 
	 * Output: integer index of the first occurrence of smallest value in array
	 * 
	 * Preconditions:
	 * Input array must not be empty, or else will return 0.
	 */
	static int indexOfMin(double[] arr) {
		int min_idx = 0;
		for (int i=1; i < arr.length; i++) {
			if (arr[i] < arr[min_idx]) {
				min_idx = i;
			}
		}
		return min_idx;
	}
	
	/* getAverage 
	 * Gets average of array of doubles.
	 *
	 * Input: array of doubles
	 * 
	 * Output: average of all values in array.
	 * 
	 * Preconditions:
	 * Array must not be empty.
	 */
	static double getAverage(double[] arr) {
		double total = 0;
		for (double x : arr) {
			total += x;
		}
		double avg = total / arr.length;
		return avg;
	}
	
}
