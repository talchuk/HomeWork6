package At_025.HomeWork_6;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MultTest {

	@Test(priority = 1)
	public void firstTestForMultMethod() {
		int x = 2;
		int y = 4;
		System.out.println("Assert for Mult");
		Assert.assertTrue(x * y == 8);

	}

	@Test(priority = 2)
	public void secondTestForMultMethod() {
		SoftAssert sa = new SoftAssert();
		try {
			int expectedResult = 12;
			Reporter.log("asserting mult method: ", true);
			sa.assertTrue(Calculator.mult(1, 12) == expectedResult,
					"multiplication result was not as expected: " + expectedResult);
			sa.assertTrue(Calculator.mult(6, 2) == expectedResult,
					"Adittion operation failure addition results was not as expected: " + expectedResult);
			sa.assertTrue(Calculator.mult(3, 4) == expectedResult);
			sa.assertTrue(Calculator.mult(-1, -12) == expectedResult, "FAIL HERE: " + expectedResult);
		} finally {
			sa.assertAll();
		}

	}

	@DataProvider(name = "multMethodDataProvider")
	public Object[][] dataProviderMult() {
		return new Object[][] { { 6, 3, 18 }, { 715827882, 3, 2147483646 }, { -715827882, 3, -2147483646 },
				{ 0, -3, 0 }, { -715827882, -3, 2147483646 } };
	}

	@Test(priority = 3, dataProvider = "multMethodDataProvider")
	public void thirdTestForMultMethod(int x, int y, int result) {

		Assert.assertEquals(Calculator.mult(x, y), result);
	}

	@Parameters({ "x", "y", "multiplication" })
	@Test (priority = 4)
	public void fourthTestForMultMethod(int x, int y, int multiplication) {

		Assert.assertEquals(Calculator.mult(x, y), multiplication);

	}

}
