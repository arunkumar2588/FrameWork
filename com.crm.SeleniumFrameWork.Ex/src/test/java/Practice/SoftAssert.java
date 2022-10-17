package Practice;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;



public class SoftAssert {
	@Test
	public void createCustomer() {
		System.out.println("step1");
		System.out.println("step2");
		SoftAssert soft=new SoftAssert();
		assertEquals("A", "B");
		System.out.println("step1");
		System.out.println("step1");
	}
	@Test
	public void modifyCustomer() {
		
		System.out.println("----------------------------------");
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
	}
}
