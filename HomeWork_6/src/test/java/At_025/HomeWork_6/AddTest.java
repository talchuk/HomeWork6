package At_025.HomeWork_6;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddTest {

	@Test(priority = 1)
	public void firstTestForAddMethod() {
		int x = 1;
		int y = 8;
		System.out.println("Assert for Add");
		Assert.assertTrue(x + y == 9);
	}

	@Test(priority = 2)
	public void secondTestForAddMethod() {
		SoftAssert sa = new SoftAssert();
		try {
			int expectedResult = 5;
			Reporter.log("asserting add method: ", true);
			sa.assertTrue(Calculator.add(2, 3) == expectedResult,
					"addition results was not as expected: " + expectedResult);
			sa.assertTrue(Calculator.add(1, 4) == expectedResult,
					"Adittion operation failure addition results was not as expected: " + expectedResult);
			sa.assertTrue(Calculator.add(0, 5) == expectedResult);
			sa.assertTrue(Calculator.add(-1, 6) == expectedResult, "FAIL HERE: " + expectedResult);
		} finally {
			sa.assertAll();
		}
	}

	@DataProvider(name = "addMethodDataProvider")
	public Object[][] dataProviderAdd() {
		return new Object[][] { { 2, 5, 7 }, { -1, 0, -1 }, { -2147483000, -647, -2147483647 },
				{ 2147483600, 47, 2147483647 } };
	}

	@Test(priority = 3, dataProvider = "addMethodDataProvider")
	public void thirdTestForAddMethod(int x, int y, int result) {

		Assert.assertEquals(Calculator.add(x, y), result);

	}

	@Parameters({ "x", "y", "sum" })
	@Test(priority = 4)
	public void fourthTestForAddMethod(int x, int y, int sum) {

		Assert.assertEquals(Calculator.add(x, y), sum);
	}

}
