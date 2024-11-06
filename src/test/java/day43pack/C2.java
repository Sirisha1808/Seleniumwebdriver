package day43pack;

import org.testng.annotations.*;

public class C2 {
	
  @Test
  void xyz() {
	
	System.out.println("this is xyz from C2....");
}
  @AfterTest
  void at() {
	System.out.println("this is After test method....");
}
}