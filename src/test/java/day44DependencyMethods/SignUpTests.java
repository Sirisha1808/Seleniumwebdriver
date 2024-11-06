package day44DependencyMethods;

import org.testng.annotations.Test;


//These three methods consider under Regression test

public class SignUpTests {
	
	@Test(priority=1, groups= {"regression"})
	void signupByEmail() {
		System.out.println("This is signup by Email");
	}
	
	@Test(priority=2, groups= {"regression"})
	void signupByFacebook() {
		System.out.println("This is signup by Facebook");
	}
	
	@Test(priority=3, groups= {"regression"})
	void signupByTwitter() {
		System.out.println("This is signuo by Twitter");
		
	}

}
