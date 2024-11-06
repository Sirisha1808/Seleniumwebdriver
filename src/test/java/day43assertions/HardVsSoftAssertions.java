package day43assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {
	
//	@Test
//	void test_hardassertions(){
//		System.out.println("before assertion testing...");
//		
//		Assert.assertEquals(1, 2);//Hard assertions
//		
//		System.out.println("after assertions testing....");
//		
//	}
	@Test
	void test_softassertions() {
        System.out.println("Before Soft assertion testing...");
        
        SoftAssert sa= new SoftAssert();
		
		sa.assertEquals(1, 2);//Soft Assertions
		
		System.out.println("After Soft assertions testing....");
		
		sa.assertAll();//this method is mandatory
	}

}
