package day44DependencyMethods;

import org.testng.annotations.Test;

public class PaymentTests {
	
	//Sanity,Regression(functional)
	//functional is combination of two groups
	
	@Test(priority=1, groups= {"sanity","regression","functional"})
	void paymentinRupees() {
		System.out.println("Payment in rupees....");
		
	}
	
	//Sanity,Regression(functional)
	@Test(priority=2, groups= {"sanity","regression","functional"})
	void paymentinDollars() {
		System.out.println("Payment in dollars....");
		
	}
	
}
