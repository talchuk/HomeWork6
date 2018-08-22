package At_025.HomeWork_6;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DivTest {

	@Test(priority = 1)
	public void firstTestForDivMethod() {
		int x = 2;
		int y = 0;
		System.out.println("Assert for Div");
		Assert.assertTrue(y / x == 0);
	}

	@Test(priority = 2)
	public void secondTestForDivMethod() {
		SoftAssert sa = new SoftAssert();
		try {
			int expectedResult = 3;
			Reporter.log("asserting div method: ", true);
			sa.assertTrue(Calculator.div(36, 12) == expectedResult,"division results was not as expected:" + expectedResult);
			sa.assertTrue(Calculator.div(18, 6) == expectedResult,
					"Adittion operation failure addition results was not as expected: " + expectedResult);
			sa.assertTrue(Calculator.div(3, 1) == expectedResult);
			sa.assertTrue(Calculator.div(-9, -3) == expectedResult, "FAIL HERE: " + expectedResult);

		} finally {
			sa.assertAll();
		}
	}

	@DataProvider(name = "divMethodDataProvider")
	public Object[][] dataProviderDiv() {
		return new Object[][] { { 6, 3, 2 },{ -100, -50, 2 } };
	}

	@Test(priority = 3, dataProvider = "divMethodDataProvider")
	public void thirdTestForDivMethod(int x, int y, int result) {

		Assert.assertEquals(Calculator.div(x, y), result);
	}

	@Parameters({ "x", "y", "division" })
    @Test (priority = 4)
    public void fourthTestForDivMethod(int x, int y, int division) {
        
        Assert.assertEquals(Calculator.div(x, y), division);
    }
}
