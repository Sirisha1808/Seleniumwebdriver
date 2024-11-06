package day42NG;

import org.testng.annotations.Test;

public class FirstTestCase {
	
	@Test(priority=1)
	void openapp() {
		System.out.println("opining application...");
	}
	@Test(priority=2)
   void login() {
		System.out.println("login to the application");
	}
	@Test(priority=3)
   void logout() {
		System.out.println("Logout from application");
	}

}
