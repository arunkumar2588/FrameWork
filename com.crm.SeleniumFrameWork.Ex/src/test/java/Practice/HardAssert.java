package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	@Test
	public void createCustomertest() {
		System.out.println("step1");
		System.out.println("step2");
		Assert.assertEquals("A", "B");
		System.out.println("step3");
		System.out.println("step4");
	}
	@Test
	public void modifyCustomertest()
	{
		System.out.println("-------------------");
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");

	}

}
