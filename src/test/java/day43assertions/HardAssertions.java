package day43assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {
	
	//Hard assertions are the methods which can directly access from the assert class so these are all static methods
	
	@Test
	void test() {
//		Assert.assertEquals("xyz","xyz");//passed
	
//		Assert.assertNotEquals(123, 321);//passed
		
		Assert.assertTrue(true);//passed
	//	Assert.assertTrue(false);//failed
	//	Assert.assertTrue(1==2);//failed
		Assert.assertTrue(1==1);//passed
		
		Assert.assertFalse(1==2);//Passes
		//Assert.assertFalse(1==1);//failed
		
		//Assert.fail();
	}

}
