package Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.BaseClass;

@Listeners(ListnerUtility.ListImpClass.class)

public class InvoiceTest extends BaseClass{
	@Test
	public void createinvoiceTest() {
		
	System.out.println("execute createinvoiceTest");
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("Step-1");
	}
	@Test
	public void createInvoicewithContactTest() {
		System.out.println("execute createInvoicewithContactTest");
		System.out.println("step-1");
	}

}
