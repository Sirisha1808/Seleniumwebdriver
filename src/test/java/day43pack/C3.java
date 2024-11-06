package day43pack;

import org.testng.annotations.*;

public class C3 {
	
	@Test
	void pqr() {
		System.out.println("This is pqr from C3");
	}
	
	@BeforeSuite
	void bs() {
		System.out.println("This is beforesuite method");
	}
	
	@AfterSuite
	void as() {
		System.out.println("This is aftersuite method");
	}
	

}
