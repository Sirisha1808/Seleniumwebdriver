package day43assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {
	
    @Test
	public void testTitle() 
	{
		String exp_title="OpenCart";
		String act_title="OpenCart";
		
		/*if(exp_title.equals(act_title))
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}*/
		
		
		if(exp_title.equals(act_title))
		{
			System.out.println("test passed");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("test failed");
			Assert.assertTrue(false);
		}
	}
}