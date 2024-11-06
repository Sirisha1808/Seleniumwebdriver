package day44DependencyMethods;

import org.testng.annotations.Test;


//These three methods consider under sanity test

public class LoginTests {
	
	@Test(priority=1, groups= {"sanity"})
	void loginByEmail() {
		
		System.out.println("This iis login by email....");
		
	}

	@Test(priority=2, groups= {"sanity"})
	void loginByFacebook() {
		System.out.println("This is login by facebook...");
	}
	
	@Test(priority=3, groups= {"sanity"})
	void loginByTwitter() {
		System.out.println("This is login by Twitter...");
	}

}
