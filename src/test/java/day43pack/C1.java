package day43pack;

import org.testng.annotations.*;

public class C1 {
	@Test
	void abc() {
		
		System.out.println("this is abc from C1....");
	}
	@BeforeTest
	void bt() {
		System.out.println("this is before test method....");
	}

}
