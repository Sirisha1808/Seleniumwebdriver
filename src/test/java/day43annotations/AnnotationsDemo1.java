package day43annotations;

import org.testng.annotations.*;

/*
 * 1) Login --@BeforeMethod
 * 2) Search --@Test
 * 3)Logout --@AfterMethod
 * 4)Login
 * 5)Advanced Search --@Test
 * 6)Logout
 */

public class AnnotationsDemo1 {
	
	@BeforeMethod
	void login() {
		System.out.println("This is login");
	}
	
	@Test(priority=1)
	void search() {
		System.out.println("This is Search");
	}
	
	@Test(priority=2)
	void advancedsearch() {
		System.out.println("This is advanced search");
	}
	
	@AfterMethod
	void logout() {
		System.out.println("This is Logout...");
	}

}
