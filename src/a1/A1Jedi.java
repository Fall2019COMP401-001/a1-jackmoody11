package a1;

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		Map<String, Integer> product_count = new HashMap<String, Integer>(); // product : number bought
		Map<String, Integer> uniq_customer_count = new HashMap<String, Integer>(); // product : number of customers who bought product
		
		// Load names of products into products array
		int num_products = scan.nextInt();
		String[] products = new String[num_products];
		for (int i=0; i<num_products; i++) {
			products[i] = scan.next();
			scan.nextDouble(); // skip over prices
		}
		
		int num_customers = scan.nextInt();
		for (int j=0; j<num_customers; j++) {
			scan.next(); // skip first name
			scan.next(); // skip last name
			int customer_products_bought = scan.nextInt();
			Set<String> products_bought = new HashSet<String>();
			
			// For each customer:
			//     - if customer bought product => add number bought to total bought for that product
			//     - if customer bought product => number of customers for product += 1
			
			for (int k=0; k<customer_products_bought; k++) {
				int count = scan.nextInt();
				String product_name = scan.next();
				products_bought.add(product_name); // use set so that products aren't double counted
				if (product_count.get(product_name) == null) {
					product_count.put(product_name, count); // initialize product count if none added yet
				} else {
					product_count.put(product_name, product_count.get(product_name)+count);
				}
			}
			for (String pb : products_bought) {
				// If no customers have bought product yet, initialize hash map values.
				// Else, add 1 to number of unique customers.
				if (uniq_customer_count.get(pb) == null) {
					uniq_customer_count.put(pb, 1); // initialize count of how many customers bought product if not initialized yet
				} else {
					uniq_customer_count.put(pb, uniq_customer_count.get(pb) + 1);
				}
			}

		}
		
		// For each product, print NUMBER customers bought TOTAL ITEM.
		// If none sold, print No customers bought ITEM.
		for (String product : products) {
			String _num_customers;
			String _num_units;
			if (uniq_customer_count.get(product) == null) {
				_num_customers = "No"; // use _ to avoid conflict with variable used earlier
				_num_units = "";
			} else {
				_num_customers = Integer.toString(uniq_customer_count.get(product));
				_num_units = Integer.toString(product_count.get(product)) + " ";
			}
			System.out.println(_num_customers + " customers bought " + _num_units + product);
		}
		scan.close();
	}
}
