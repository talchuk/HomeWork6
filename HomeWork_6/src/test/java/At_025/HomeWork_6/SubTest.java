package At_025.HomeWork_6;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SubTest {

	@Test(priority = 1)
	public void firstTestForSubMethod() {
		int x = 6;
		int y = 4;
		System.out.println("Assert for Sub");
		Assert.assertTrue(x - y == 2);
	}

	@Test(priority = 2)
	public void secondTestForSubMethod() {
		SoftAssert sa = new SoftAssert();
		try {
			int expectedResult = 3;
			Reporter.log("asserting sub method: ", true);
			sa.assertTrue(Calculator.sub(2147483647, 2147483644) == expectedResult,
					"Adittion operation failure addition results was not as expected: " + expectedResult);
			sa.assertTrue(Calculator.sub(8, 5) == expectedResult,
					"Subtraction results was not as expected: " + expectedResult);
			sa.assertTrue(Calculator.sub(3, 0) == expectedResult, "FAIL HERE: " + expectedResult);
		} finally {
			sa.assertAll();
		}
	}

	@DataProvider(name = "subMethodDataProvider")
	public Object[][] dataProviderSub() {
		return new Object[][] { { 6, 5, 1 }, { -2147483647, -2147483646, -1 }, { -2147483647, 0, -2147483647 },
				{ 0, 0, 0 }, { 2147483647, 0, 2147483647 } };
	}

	@Test(priority = 3, dataProvider = "subMethodDataProvider")
	public void thirdTestForSubMethod(int x, int y, int result) {

		Assert.assertEquals(Calculator.sub(x, y), result);
	}

	@Parameters({ "x", "y", "difference" })

	@Test (priority = 4)
	public final void fourthTestForSubMethod(int x, int y, int difference) {

		Assert.assertEquals(Calculator.sub(x, y), difference);
	}

}
